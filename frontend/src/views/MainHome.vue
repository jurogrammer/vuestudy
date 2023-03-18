<template>
  <div class="home">
    <h1>Welcome to my home page</h1>
    <p>{{ message }}</p>
  </div>
</template>

<script lang="ts">
import {defineComponent} from 'vue';

export default defineComponent({
  name: 'MainHome',
  data() {
    return {
      message: 'This is the Home page.',
    };
  },
});
</script>

<style scoped>
.home {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}
</style>
