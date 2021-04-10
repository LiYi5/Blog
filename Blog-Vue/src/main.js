import Vue from 'vue'
import App from './App'
import router from './router'
import semantic from '../node_modules/semantic-ui-css/semantic.min.js'
import '../node_modules/semantic-ui-css/semantic.min.css'
import less from 'less'

Vue.use(semantic)
Vue.use(less)
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
