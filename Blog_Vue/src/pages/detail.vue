<template>
  <div>
    <Header :cur=curIndex></Header>
    <div class="ui container blank-top left aligned backimg">
      <div class="ui top attached segment">
        <div class="ui horizontal link list">
          <div class="item">
            <img
              :src=blogInfo.avatar
              alt=""
              class="ui avatar image"
            />
            <div class="content"><a class="header">{{blogInfo.username}}</a></div>
          </div>
          <div class="item"><i class="calendar icon"></i>{{rTime(blogInfo.creat_time)}}</div>
          <div class="item"><i class="eye icon"></i>{{blogInfo.views}}</div>
        </div>
      </div>
      <div class="ui attached segment">
        <img
          :src=blogInfo.first_picture
          alt=""
          class="ui fluid rounded image"
        />
      </div>
      <div class="ui attached segment">
        <div class="ui right aligned basic segment">
        </div>
        <h2 class="ui header center aligned">{{blogInfo.title}}</h2>
        <div id="content" class="con-content typo typo-selection">
          {{blogInfo.content}}
        </div>
        <div class="con-label">
          <div class="ui basic teal label">{{blogInfo.name}}</div>
          <a class="ui right floated teal basic button" @click="goback">返回</a>
        </div>
      </div>
    </div>
    <div>
      <Footer></Footer>
    </div>
  </div>
</template>

<script>
import Footer from '../components/footer.vue'
import Header from '../components/header.vue'
export default {
  components: {
    Footer,
    Header
  },
  data () {
    return {
      curIndex: 0,
      blogInfo: Object
    }
  },
  mounted () {
    this.moutedIndex()
  },
  methods: {
    goback () {
      this.$router.go(-1)
    },
    rTime (date) {
      var d = new Date(date).toJSON()
      return new Date(new Date(d) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '')
    },
    moutedIndex () {
      this.curIndex = +this.$route.query.curindex
      this.blogInfo = JSON.parse(this.$route.query.blogInfo)
      console.log(this.blogInfo)
    }
  }
}
</script>

<style>
.blank-top {
  margin: 3em auto;
  max-width: 60em !important;
}
.con-content{
  padding: 3em 4em 2em 4em !important;
  font-size: 16px;
  line-height: 22px;
}
.con-label{
  padding: 0 4em 2em 4em!important;
}
.backimg{
  background: url('../assets/detailback.jpg')!important;
}
</style>
