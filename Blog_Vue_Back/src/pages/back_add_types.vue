<template>
  <div>
    <!-- 导航 -->
    <Header :cur=2></Header>
    <div class="ui attached menu">
     <div class="ui container">
       <div class="right menu">
        <a href="" class="item active teal">发布</a>
         <a href="" class="item">列表</a>
       </div>
     </div>
    </div>
    <!-- 中间内容 -->
    <div class="m-main-padded-tb">
      <div class="ui container">
      <form class="ui left aligned segment form">
        <div class="field">
      </div>
         <div class="field">
           <div class="ui left labeled input">
             <label class="ui teal basic label">名称</label>
              <input type="text" v-model="type_name" placeholder="分类名称">
           </div>
         </div>
         <div class="ui right aligned container">
           <button class="ui button" type="button" @click="back">返回</button>
           <button class="ui teal button submit" @click="submitType()">{{this.$route.query.btnname}}</button>
         </div>
      </form>
      </div>
    </div>
    <!-- 底部 -->
    <div class="foot_b">
      <Footer></Footer>
    </div>
  </div>
</template>

<script>
import Footer from '../components/footer.vue'
import Header from '../components/header.vue'
import $ from 'jquery'
import {postNewTypes, updateTypes} from '../mock/index'
export default {
  components: {
    Footer,
    Header
  },
  mounted () {
    this.mountTypeName()
    this.dropdown()
  },
  data () {
    return {
      content: '',
      type_name: null
    }
  },
  methods: {
    mountTypeName () {
      if (this.$route.query.typename !== undefined) {
        this.type_name = this.$route.query.typename
      }
    },
    back () {
      window.history.back()
    },
    dropdown () {
      $('.ui.dropdown').dropdown()
    },
    submitType () {
      if (this.type_name === null) {
        this.$message({
          message: '分类名称不能为空',
          type: 'error',
          duration: 1000,
          offset: 100,
          center: true
        })
      } else {
        if (this.$route.query.btnname === '增加') {
          postNewTypes({name: this.type_name}).then((res) => {
            if (res.code === '1') {
              this.$router.go(-1)
              localStorage.setItem('addType', true)
            } else {
              this.$message({
                message: res.msg,
                type: 'error',
                duration: 1000,
                offset: 100,
                center: true
              })
            }
          })
        } else if (this.$route.query.btnname === '修改') {
          updateTypes({id: this.$route.query.typeid, name: this.type_name}).then((res) => {
            if (res.code === '1') {
              this.$router.go(-1)
              localStorage.setItem('editType', true)
            } else {
              this.$message({
                message: res.msg,
                type: 'error',
                duration: 1000,
                offset: 100,
                center: true
              })
            }
          })
        }
      }
    }
  }
}
</script>

<style lang="less">
.baw{
  background-color: white!important;
}
.black-text{
  color: #333!important;
}
.margin-con-tp{
  margin: 0.3em 0 !important;
  margin-left: 0.6em!important;
}
.padding-con-lr{
    padding: 1em 1em !important;
}
.m-main-padded-tb {
  padding: 2em 0 !important;
}
.m-padded-tb-mini {
  padding: 0 0.2em;
}
.m-inline-block {
  display: inline-block;
}
</style>
