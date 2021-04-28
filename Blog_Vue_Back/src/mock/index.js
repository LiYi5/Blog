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

export const getTypes =(params)=>get('/Type/Types',params)
export const postNewTypes =(params)=>post('/Type/newType',params)
export const deleteTypes =(params)=>post('/Type/deleteType',params)
export const updateTypes =(params)=>post('/Type/updateType',params)
export const getAllTypes =()=>get('/Type/AllTypes')

export const getTags =(params)=>get('/Tag/Tags',params)
export const postNewTags =(params)=>post('/Tag/newTag',params)
export const deleteTags =(params)=>post('/Tag/deleteTag',params)
export const updateTags =(params)=>post('/Tag/updateTag',params)

export const getBlogs =(params)=>get('/Blog/Blogs',params)
