import {createRouter, createWebHistory, RouteRecordRaw} from 'vue-router';
import MyHome from '@/views/MainHome.vue';
import MyAbout from '@/views/MainAbout.vue';
import MyContact from '@/views/MainContact.vue';

const routes: Array<RouteRecordRaw> = [
    {path: '/', component: MyHome},
    {path: '/about', component: MyAbout},
    {path: '/contact', component: MyContact},
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;