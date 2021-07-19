import axios from "axios";
import {Message} from "element-ui";
import local from "@/store/local";
import router from "@/router";
import {message} from '@/utils/message'

const instance = axios.create({
    baseURL: 'http://127.0.0.1:8080/applyjob',
    timeout: 12000,   //12秒
})

//配置请求拦截器
instance.interceptors.request.use(function (config) {
    // 在发送请求之前做些什么
    if(local.getToken()){
        config.headers.token = local.getToken();
    }
    return config;
}, function (error) {
    // 对请求错误做些什么
    return Promise.reject(error);
});

//配置响应拦截器

instance.interceptors.response.use(function (response) {
    // 对响应数据做点什么
    const res = response.data;
    console.log("backdata=",res);
    if(response.status == 200){
        if(res.code == 200){
            return res;
        }else if(res.code == 401){
            message.error(res.msg)
            router.push('/login')
        }else if(res.code == 402){
            message.error(res.msg)
            router.push('/login')
        }else if(res.code == 500){
            message.error(res.msg)
            throw res.msg;
        }
    }else{
        message.error(res.msg)
    }
}, function (error) {
    // 对响应错误做点什么
    return Promise.reject(error);
});

export default instance