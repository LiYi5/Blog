import Vue from 'vue'
import Router from 'vue-router'
// import Home from '../pages/back_home.vue'
import Edit from '../pages/back_edit.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Edit
    }
  ]
})
