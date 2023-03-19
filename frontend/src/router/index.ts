import {createRouter, createWebHistory, RouteRecordRaw} from 'vue-router';
import MyHome from '@/views/MainHome.vue';
import UserList from '@/views/user/UserList.vue'

const routes: Array<RouteRecordRaw> = [
    {path: '/', component: MyHome},
    {path: '/users', component: UserList},
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;