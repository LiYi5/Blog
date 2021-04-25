import Vue from 'vue'
import App from './App'
import router from './router'
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
import less from 'less'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import semantic from '../node_modules/semantic-ui-css/semantic.min.js'
import '../node_modules/semantic-ui-css/semantic.min.css'

Vue.use(ElementUI)
Vue.use(semantic)
Vue.use(less)
Vue.use(mavonEditor)
Vue.config.productionTip = false

router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth) {
    if (localStorage.getItem('user')) {
      next()
    } else {
      next({
        path: '/'
      })
    }
  } else {
    next()
  }
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
