<template>
  <div class="about">
    <h1>About Me</h1>
    <p>{{ message }}</p>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'MainAbout',
  data() {
    return {
      message: 'I am a web developer with experience in Vue3 and TypeScript.',
    };
  },
});
</script>

<style scoped>
.about {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}
</style>
