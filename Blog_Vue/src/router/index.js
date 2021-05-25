import Vue from 'vue'
import Router from 'vue-router'
import Home from '../pages/home.vue'
import Detail from '../pages/detail.vue'
import Types from '../pages/types.vue'
import Tags from '../pages/tags.vue'
import Archives from '../pages/archives.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/Detail',
      name: 'Detail',
      component: Detail
    },
    {
      path: '/Types',
      name: 'Types',
      component: Types
    },
    {
      path: '/Tags',
      name: 'Tags',
      component: Tags
    },
    {
      path: '/Archives',
      name: 'Archives',
      component: Archives
    }
  ]
})
