import Vue from 'vue'
import VueRouter from 'vue-router'


Vue.use(VueRouter)

const router =new VueRouter({
    routes:[
        {
            path: '/login',
            name: 'login',
            component: () => import('@/views/Login'),

        },
        {
            path: '/index',
            name: 'index',
            component: () => import('@/views/Index'),

        }
    ]
})

export default router