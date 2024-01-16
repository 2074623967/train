import { createRouter, createWebHistory } from 'vue-router';

const routes = [
  {
    path: '/',
    component: () => import('@/views/Main.vue'),
    meta: {
      loginRequire: true,
    },
    children: [
      {
        path: 'welcome',
        component: () => import('../views/main/welcome.vue'),
      },
      {
        path: 'about',
        component: () => import('../views/main/about.vue'),
      },
      {
        path: 'station',
        component: () => import('../views/main/stations.vue'),
      },
    ],
  },
  {
    path: '',
    redirect: '/welcome',
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
