import Vue from 'vue'
import Router from 'vue-router'
import Home from '../pages/back_home.vue'
import Edit from '../pages/back_edit.vue'
import Login from '../pages/back_login.vue'
import Types from '../pages/back_types.vue'
import Tags from '../pages/back_tags.vue'
import addTypes from '../pages/back_add_types.vue'

Vue.use(Router)

const VueRouterPush = Router.prototype.push
Router.prototype.push = function push (to) {
  return VueRouterPush.call(this, to).catch(err => err)
}
export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/home',
      name: 'Home',
      meta: {
        requireAuth: true
      },
      component: Home
    },
    {
      path: '/edit',
      name: 'Edit',
      meta: {
        requireAuth: true
      },
      component: Edit
    },
    {
      path: '/types',
      name: 'Types',
      meta: {
        requireAuth: true
      },
      component: Types
    },
    {
      path: '/addTypes',
      name: 'addTypes',
      meta: {
        requireAuth: true
      },
      component: addTypes
    },
    {
      path: '/tags',
      name: 'Tags',
      meta: {
        requireAuth: true
      },
      component: Tags
    }
  ]
})
