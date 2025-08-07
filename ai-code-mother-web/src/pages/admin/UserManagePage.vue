<template>
  <div id="userManagePage">
    <!-- 添加用户的弹窗 -->
    <a-modal
      v-model:visible="addModalVisible"
      title="添加用户"
      ok-text="创建"
      cancel-text="取消"
      @ok="handleAdd"
    >
      <a-form :model="addForm" layout="vertical">
        <a-form-item label="账号" required>
          <a-input v-model:value="addForm.userAccount" placeholder="请输入账号" />
        </a-form-item>
        <a-form-item label="用户名">
          <a-input v-model:value="addForm.userName" placeholder="请输入用户名" />
        </a-form-item>
        <a-form-item label="头像URL">
          <a-input v-model:value="addForm.userAvatar" placeholder="请输入头像URL" />
        </a-form-item>
        <a-form-item label="个人简介">
          <a-textarea
            v-model:value="addForm.userProfile"
            placeholder="请输入个人简介"
            :auto-size="{ minRows: 3, maxRows: 5 }"
          />
        </a-form-item>
        <a-form-item label="用户角色">
          <a-select v-model:value="addForm.userRole" placeholder="请选择用户角色">
            <a-select-option value="user">普通用户</a-select-option>
            <a-select-option value="admin">管理员</a-select-option>
          </a-select>
        </a-form-item>
      </a-form>
    </a-modal>

    <!-- 编辑用户信息的弹窗 -->
    <a-modal
      v-model:visible="editModalVisible"
      title="编辑用户信息"
      ok-text="保存"
      cancel-text="取消"
      @ok="handleEdit"
    >
      <a-form :model="editForm" layout="vertical">
        <a-form-item label="用户名">
          <a-input v-model:value="editForm.userName" placeholder="请输入用户名" />
        </a-form-item>
        <a-form-item label="头像URL">
          <a-input v-model:value="editForm.userAvatar" placeholder="请输入头像URL" />
        </a-form-item>
        <a-form-item label="个人简介">
          <a-textarea
            v-model:value="editForm.userProfile"
            placeholder="请输入个人简介"
            :auto-size="{ minRows: 3, maxRows: 5 }"
          />
        </a-form-item>
        <a-form-item label="用户角色">
          <a-select v-model:value="editForm.userRole" placeholder="请选择用户角色">
            <a-select-option value="user">普通用户</a-select-option>
            <a-select-option value="admin">管理员</a-select-option>
          </a-select>
        </a-form-item>
      </a-form>
    </a-modal>
    <!-- 搜索表单 -->
    <a-form layout="inline" :model="searchParams" @finish="doSearch">
      <a-form-item label="账号">
        <a-input v-model:value="searchParams.userAccount" placeholder="输入账号" />
      </a-form-item>
      <a-form-item label="用户名">
        <a-input v-model:value="searchParams.userName" placeholder="输入用户名" />
      </a-form-item>
      <a-form-item>
        <a-button type="primary" html-type="submit">搜索</a-button>
      </a-form-item>
      <a-form-item>
        <a-button type="primary" @click="showAddModal">添加用户</a-button>
      </a-form-item>
    </a-form>
    <a-divider />
    <a-table
      :columns="columns"
      :data-source="data"
      :pagination="pagination"
      @change="doTableChange"
    >
      <!-- 表格 -->
      <template #bodyCell="{ column, record }">
        <template v-if="column.dataIndex === 'userAvatar'">
          <a-image :src="record.userAvatar" :width="120" />
        </template>
        <template v-else-if="column.dataIndex === 'userRole'">
          <div v-if="record.userRole === 'admin'">
            <a-tag color="green">管理员</a-tag>
          </div>
          <div v-else>
            <a-tag color="blue">普通用户</a-tag>
          </div>
        </template>
        <template v-else-if="column.dataIndex === 'createTime'">
          {{ dayjs(record.createTime).format('YYYY-MM-DD HH:mm:ss') }}
        </template>
        <template v-else-if="column.key === 'action'">
          <a-space>
            <a-button type="primary" @click="showEditModal(record)">编辑</a-button>
            <a-button danger @click="doDelete(record.id)">删除</a-button>
          </a-space>
        </template>
      </template>
    </a-table>
  </div>
</template>
<script lang="ts" setup>
import { SmileOutlined, DownOutlined } from '@ant-design/icons-vue'
import { addUser, deleteUser, listUserVoByPage, updateUser } from "@/api/userController.ts";
import { computed, onMounted, reactive, ref } from 'vue'
import { message } from 'ant-design-vue'
import dayjs from 'dayjs'
const columns = [
  {
    title: 'id',
    dataIndex: 'id',
  },
  {
    title: '账号',
    dataIndex: 'userAccount',
  },
  {
    title: '用户名',
    dataIndex: 'userName',
  },
  {
    title: '头像',
    dataIndex: 'userAvatar',
  },
  {
    title: '简介',
    dataIndex: 'userProfile',
  },
  {
    title: '用户角色',
    dataIndex: 'userRole',
  },
  {
    title: '创建时间',
    dataIndex: 'createTime',
  },
  {
    title: '操作',
    key: 'action',
  },
]
// 数据
const data = ref<API.UserVO[]>([])
const total = ref(0)

// 搜索条件
const searchParams = reactive<API.UserQueryRequest>({
  pageNum: 1,
  pageSize: 10,
})

// 获取数据
const fetchData = async () => {
  const res = await listUserVoByPage({
    ...searchParams,
  })
  if (res.data.data) {
    data.value = res.data.data.records ?? []
    total.value = res.data.data.totalRow ?? 0
  } else {
    message.error('获取数据失败，' + res.data.message)
  }
}
// 分页参数
const pagination = computed(() => {
  return {
    current: searchParams.pageNum ?? 1,
    pageSize: searchParams.pageSize ?? 10,
    total: total.value,
    showSizeChanger: true,
    showTotal: (total: number) => `共 ${total} 条`,
  }
})

// 表格变化处理
const doTableChange = (page: any) => {
  searchParams.pageNum = page.current
  searchParams.pageSize = page.pageSize
  fetchData()
}

// 获取数据
const doSearch = () => {
  // 重置页码
  searchParams.pageNum = 1
  fetchData()
}
// 删除数据
const doDelete = async (id: string) => {
  if (!id) {
    return
  }
  const res = await deleteUser({ id })
  if (res.data.code === 0) {
    message.success('删除成功')
    // 刷新数据
    fetchData()
  } else {
    message.error('删除失败')
  }
}

// 添加用户表单数据
const addModalVisible = ref(false)
const addForm = reactive<API.UserAddRequest>({
  userAccount: '',
  userName: '',
  userAvatar: '',
  userProfile: '',
  userRole: 'user',
})

// 显示添加用户弹窗
const showAddModal = () => {
  // 重置表单
  addForm.userAccount = ''
  addForm.userName = ''
  addForm.userAvatar = ''
  addForm.userProfile = ''
  addForm.userRole = 'user'
  addModalVisible.value = true
}

// 处理添加用户提交
const handleAdd = async () => {
  if (!addForm.userAccount) {
    message.error('用户账号不能为空')
    return
  }

  try {
    const res = await addUser(addForm)
    if (res.data.code === 0) {
      message.success('添加用户成功')
      addModalVisible.value = false
      // 刷新数据
      fetchData()
    } else {
      message.error('添加用户失败：' + (res.data.message || '未知错误'))
    }
  } catch (error) {
    message.error('添加用户失败，请稍后重试')
    console.error('Add user error:', error)
  }
}

// 编辑表单数据
const editModalVisible = ref(false)
const editForm = reactive<API.UserUpdateRequest>({
  id: undefined,
  userName: '',
  userAvatar: '',
  userProfile: '',
  userRole: 'user',
})

// 显示编辑弹窗
const showEditModal = (record: API.UserVO) => {
  editForm.id = record.id
  editForm.userName = record.userName || ''
  editForm.userAvatar = record.userAvatar || ''
  editForm.userProfile = record.userProfile || ''
  editForm.userRole = record.userRole || 'user'
  editModalVisible.value = true
}

// 处理编辑提交
const handleEdit = async () => {
  if (editForm.id === undefined) {
    message.error('用户ID不能为空')
    return
  }

  try {
    const res = await updateUser(editForm)
    if (res.data.code === 0) {
      message.success('更新成功')
      editModalVisible.value = false
      // 刷新数据
      fetchData()
    } else {
      message.error('更新失败：' + (res.data.message || '未知错误'))
    }
  } catch (error) {
    message.error('更新失败，请稍后重试')
    console.error('Update error:', error)
  }
}

// 页面加载时请求一次
onMounted(() => {
  fetchData()
})
</script>
