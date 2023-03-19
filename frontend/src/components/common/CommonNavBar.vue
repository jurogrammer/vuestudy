<template>
  <nav>
    <router-link class="link" to="/">Home</router-link>
    <router-link class="link" to="/users">유저 목록</router-link>
  </nav>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'CommonNavbar',
});
</script>


<style>
.link {
  color: #333;
  text-decoration: none;
  transition: color 0.2s ease;
  font-size: 1.2rem;
  font-weight: bold;
  margin-right: 1rem;
}

.link:hover {
  color: #555;
}
</style>