<script lang="ts">
import {defineComponent} from 'vue';
import CommonNavBar from '@/components/common/CommonNavBar.vue';

export default defineComponent({
  name: 'App',
  components: {
    CommonNavBar,
  },
});
</script>

<template>
  <div>
    <CommonNavBar/>
    <router-view/>
  </div>
</template>
