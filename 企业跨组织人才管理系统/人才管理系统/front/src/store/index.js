import Vue from 'vue'
import Vuex from 'vuex'
import {login} from '@/api/login'
import local from './local'
import {queryMenus} from "@/api/menu";
import router from "@/router";
import {userRouterMap} from '@/router/user_router'
import {companyRouterMap} from '@/router/company_router'
import {studentRouterMap} from '@/router/student_router'
import {resetRouter} from "@/router";

Vue.use(Vuex)

const  store = new Vuex.Store({
    state:{
        token:null,
        userInfo:null
    },
    getters:{},
    mutations:{
        SET_TOKEN:(state,token)=>{
            state.token = token
        },
        SET_USERINFO:(state,userInfo)=>{
            state.userInfo = userInfo
        }
    },
    actions:{
        login({commit},loginUser){
            return new Promise((resolve,reject)=>{
                login(loginUser).then(res=>{
                    if(res){
                        commit('SET_TOKEN',res.data.token)
                        commit('SET_USERINFO',res.data)
                        local.setToken(res.data.token)
                        local.setUserInfo(res.data)
                        resetRouter()
                        if(res.data.type == 0){//管理员
                            router.addRoutes(userRouterMap)
                        }
                        if(res.data.type == 1){//企业
                            router.addRoutes(companyRouterMap)
                        }
                        if(res.data.type == 2){//普通用户
                            router.addRoutes(studentRouterMap)
                        }
                        resolve(res)
                    }
                }).catch(error=>{
                    reject(error);
                })
            })
        },
        getMenus({commit}){
            return new Promise((resolve,reject)=>{
                queryMenus().then(res=>{
                    resolve(res);
                })
            })
        }
    },
});

export default store