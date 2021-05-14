<template>
  <div>
    <Header :cur=4></Header>
   <div>
      <div class="ui container blank-top left aligned">
         <div class="ui top attached segment">
              <div class="ui middle aligned two column grid">
                <div class="column">
                  <h3 class="ui teal header">归档</h3>
                </div>
                <div class="column right aligned">
                  共
                  <h2 class="ui orange header m-inline-block">24</h2>
                  个
                </div>
              </div>
            </div>
            <h2 class="ui center aligned header">2017</h2>
            <div class="ui fluid vertical menu">
              <a href="#" target="_blank" class="item">
                <span>
                  <i class="circle teal mini icon"></i>关于刻意练习
                  <div class="ui teal basic left pointing label mini">9月03</div>
                </span>
                    <div class="ui orange basic left pointing label mini">原创</div>
              </a>
              <a href="#" target="_blank" class="item">
                <span>
                  <i class="circle teal mini icon"></i>关于刻意练习
                  <div class="ui teal basic left pointing label mini">9月03</div>
                </span>
                    <div class="ui orange basic left pointing label mini">原创</div>
              </a>
              <a href="#" target="_blank" class="item">
                <span>
                  <i class="circle teal mini icon"></i>关于刻意练习
                  <div class="ui teal basic left pointing label mini">9月03</div>
                </span>
                    <div class="ui orange basic left pointing label mini">原创</div>
              </a>
              <a href="#" target="_blank" class="item">
                <span>
                  <i class="circle teal mini icon"></i>关于刻意练习
                  <div class="ui teal basic left pointing label mini">9月03</div>
                </span>
                    <div class="ui orange basic left pointing label mini">原创</div>
              </a>
              <a href="#" target="_blank" class="item">
                <span>
                  <i class="circle teal mini icon"></i>关于刻意练习
                  <div class="ui teal basic left pointing label mini">9月03</div>
                </span>
                    <div class="ui orange basic left pointing label mini">原创</div>
              </a>
            </div>
      </div>
   </div>
    <Footer></Footer>
  </div>
</template>

<script>
import Footer from '../components/footer.vue'
import Header from '../components/header.vue'
export default {
  components: {
    Footer,
    Header
  }
}
</script>

<style>
.padding-con-lr{
    padding: 1em 1em !important;
}
.con-m-label{
  margin: 0 0.5em 1em 0.5em!important;
}
.m-inline-block {
  display: inline-block;
}
.blank-top {
  margin: 3em auto;
  max-width: 60em !important;
}
</style>
