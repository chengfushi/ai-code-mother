<template>
  <div class="userProfilePage">
    <a-card :bordered="false" class="profile-card">
      <div class="profile-header">
        <div
          class="custom-avatar"
          :style="{ width: '120px', height: '120px', borderRadius: '50%' }"
        >
          <template v-if="userData.userAvatar">
            <a-image :src="userData.userAvatar" :width="120" style="border-radius: 50%" />
          </template>
          <template v-else>
            <div
              style="
                width: 100%;
                height: 100%;
                background-color: #1890ff;
                border-radius: 50%;
                display: flex;
                justify-content: center;
                align-items: center;
                color: white;
                font-size: 36px;
              "
            >
              {{ userData.userName?.charAt(0) || 'U' }}
            </div>
          </template>
        </div>
        <div class="profile-info">
          <h2>{{ userData.userName }}</h2>
          <p class="account-info">@{{ userData.userAccount }}</p>
          <a-tag :color="userData.userRole === 'admin' ? 'red' : 'blue'">
            {{ userData.userRole === 'admin' ? '管理员' : '普通用户' }}
          </a-tag>
        </div>
      </div>

      <a-divider />

      <div class="profile-details">
        <a-descriptions :column="1" bordered>
          <a-descriptions-item label="账号ID">{{ userData.id }}</a-descriptions-item>
          <a-descriptions-item label="个人简介">
            {{ userData.userProfile || '暂无简介' }}
          </a-descriptions-item>
          <a-descriptions-item label="创建时间">
            {{ formatDate(userData.createTime) }}
          </a-descriptions-item>
          <a-descriptions-item label="最后更新时间">
            {{ formatDate(userData.updateTime) }}
          </a-descriptions-item>
        </a-descriptions>
      </div>

      <div class="profile-actions">
        <a-button type="primary" @click="showEditModal">编辑资料</a-button>
        <a-button v-if="userData.userRole === 'admin'" style="margin-left: 10px" @click="goManage">
          管理后台
        </a-button>
      </div>
    </a-card>
    <a-modal
      v-model:visible="editModalVisible"
      title="编辑资料"
      ok-text="保存"
      cancel-text="取消"
      @ok="handleEdit"
      @cancel="handleCancel"
    >
      <a-form :model="updateUserForm" layout="vertical">
        <a-form-item label="用户名">
          <a-input v-model:value="updateUserForm.userName" placeholder="请输入用户名" />
        </a-form-item>
        <a-form-item label="头像URL">
          <a-input v-model:value="updateUserForm.userAvatar" placeholder="请输入头像URL" />
        </a-form-item>
        <a-form-item label="个人简介">
          <a-textarea
            v-model:value="updateUserForm.userProfile"
            placeholder="请输入个人简介"
            :auto-size="{ minRows: 3, maxRows: 5 }"
          />
        </a-form-item>
      </a-form>
    </a-modal>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted, reactive } from 'vue'
import { message, type UploadProps } from 'ant-design-vue'
import { getLoginUser } from '@/api/userController'
import router from '@/router'
import { userEdit } from '@/api/userController'
import { LoadingOutlined, PlusOutlined } from '@ant-design/icons-vue'

const editModalVisible = ref(false)
const userData = ref({
  id: '',
  userAccount: '',
  userName: '',
  userAvatar: null,
  userProfile: null,
  userRole: '',
  editTime: '',
  createTime: '',
  updateTime: '',
})

const updateUserForm = reactive<API.UserUpdateRequest>({
  id: '',
  userName: '',
  userAvatar: '',
  userProfile: '',
})

const formatDate = (dateString: string) => {
  if (!dateString) return '未知时间'
  return new Date(dateString).toLocaleString()
}

const fetchUserProfile = async () => {
  try {
    // Assuming the API returns data in the format you provided
    const res = await getLoginUser()
    if (res.data.code === 0 && res.data.data) {
      userData.value = res.data.data
    } else {
      message.error('获取用户信息失败: ' + (res.data.message || '未知错误'))
    }
  } catch (error) {
    message.error('网络错误，请稍后重试')
    console.error('Fetch profile error:', error)
  }
}

const showEditModal = () => {
  // Fill the form with current user data
  updateUserForm.id = userData.value.id
  updateUserForm.userName = userData.value.userName || ''
  updateUserForm.userAvatar = userData.value.userAvatar || ''
  updateUserForm.userProfile = userData.value.userProfile || ''
  editModalVisible.value = true
}

const handleEdit = async () => {
  try {
    const res = await userEdit(updateUserForm)
    if (res.data.code === 0) {
      message.success('资料更新成功')
      editModalVisible.value = false
      fetchUserProfile() // Refresh user data
    } else {
      message.error('更新失败: ' + (res.data.message || '未知错误'))
    }
  } catch (error) {
    message.error('网络错误，请稍后重试')
    console.error('Update profile error:', error)
  }
}

const handleCancel = () => {
  editModalVisible.value = false
}

const goManage = () => {
  router.push('/admin/user')
}

onMounted(() => {
  fetchUserProfile()
})
</script>

<style scoped>
.userProfilePage {
  padding: 24px;
  max-width: 800px;
  margin: 0 auto;
}

.profile-card {
  border-radius: 8px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}

.profile-header {
  display: flex;
  align-items: center;
  margin-bottom: 24px;
}

.user-avatar {
  margin-right: 24px;
  background-color: #1890ff;
  color: white;
  font-size: 36px;
}

.profile-info h2 {
  margin-bottom: 8px;
  font-size: 24px;
}

.account-info {
  color: #666;
  margin-bottom: 12px;
}

.profile-details {
  margin: 24px 0;
}

.profile-actions {
  margin-top: 24px;
  text-align: center;
}

@media (max-width: 768px) {
  .profile-header {
    flex-direction: column;
    text-align: center;
  }

  .user-avatar {
    margin-right: 0;
    margin-bottom: 16px;
  }
}
</style>
