/* eslint-disable */
import axios from 'axios'
const Axios = axios.create({})
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
          resolve(res)
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


export const getNot =()=>get('/index')
