<template>
  <form id="search" @submit.prevent="search">
    <select name="searchType" id="searchType" v-model="searchParam.searchType">
      <option>NAME</option>
      <option>PHONE</option>
    </select>
    <input type="text" v-model="searchParam.query">

    <select name="role" id="role" v-model="searchParam.role">
      <option>NORMAL</option>
      <option>ADMIN</option>
    </select>

    <input type="date" name="startAt" id="startAt" v-model="searchParam.startAt">
    <input type="date" name="startAt" id="startAt" v-model="searchParam.endAt">
  </form>

  <table>
    <tr>
      <th>ID</th>
      <th>이름</th>
      <th>핸드폰 번호</th>
      <th>롤</th>
      <th>가입일자</th>
      <th>수정일자</th>
    </tr>
    <tr v-for="user in userList" :key="user.id">
      <td>{{user.id}}</td>
      <td>{{user.name}}</td>
      <td>{{user.phoneNumber}}</td>
      <td>{{user.userRole}}</td>
      <td>{{user.createdAt}}</td>
      <td>{{user.updatedAt}}</td>
    </tr>

  </table>
</template>

<script lang="ts">
import {defineComponent} from "vue";

export default defineComponent({
  name: "UserList",
  data() {
    return {
      searchParam: {
        page: 0,
        size: 20,
        searchType: 'NAME', //NAME, PHONE
        query: '',
        role: 'NORMAL',
        startAt: new Date(Date.now() - 14 * 24 * 60 * 60 * 1000).toISOString().split('T')[0],
        endAt: new Date().toISOString().split('T')[0]
      },
      userList: []
    }
  },
  methods: {
    search() {
      fetch(`http://localhost:8080/api/users?page=${this.searchParam.page}&size=${this.searchParam.size}&searchType=${this.searchParam.searchType}&query=${this.searchParam.query}&role=${this.searchParam.role}&startAt=${this.searchParam.startAt}&endAt=${this.searchParam.endAt}`)
          .then(response => response.json())
          .then(data => this.userList = data)
    }
  }
})
</script>

<style scoped>

</style>