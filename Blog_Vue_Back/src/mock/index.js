/* eslint-disable */
import axios from 'axios'
const Axios = axios.create({
  withCredentials:true
})
const baseUrl = 'http://127.0.0.1:8089'

Axios.interceptors.request.use((config) => {
  return config
}, (err) => {
  return Promise.reject(err)
})
Axios.interceptors.response.use((data) => {
  return Promise.resolve(data)
})


function get(url, params){    
  return new Promise((resolve, reject) =>{        
      axios.get(baseUrl + url, {            
          params: params        
      }).then(res => {
          resolve(res.data)
      }).catch(err =>{
          reject(err)        
  })    
})
}

function post(url, params) {
  return new Promise((resolve, reject) => {
       axios.post(baseUrl + url, params)
      .then(res => {
          resolve(res.data)
      })
      .catch(err =>{
          reject(err)
      })
  })
}


export const postLogin =(params)=>post('/admin/login',params)
export const getLogout =()=>get('/admin/logout')
export const getTypes =(params)=>get('/admin/types',params)
export const postNewTypes =(params)=>post('/admin/newtype',params)
export const deleteTypes =(params)=>post('/admin/deleteType',params)
export const updateTypes =(params)=>post('/admin/updateType',params)
