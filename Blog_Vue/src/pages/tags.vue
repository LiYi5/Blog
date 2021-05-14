<template>
  <div>
    <Header :cur=3></Header>
   <div>
      <div class="ui container blank-top left aligned">
           <div class="ui top attached segment">
              <div class="ui middle aligned two column grid">
                <div class="column">
                  <h3 class="ui teal header">标签</h3>
                </div>
                <div class="column right aligned">
                  共
                  <h2 class="ui orange header m-inline-block">14</h2>
                  个
                </div>
              </div>
            </div>
            <div class="ui attached segment">
                <a href="#" class="ui teal basic label large margin-con-tp con-m-label">
                    方法论
                    <div class="detail">13</div>
                  </a>
                <a href="#" class="ui basic label large margin-con-tp con-m-label">
                    方法论
                    <div class="detail">13</div>
                  </a>
                <a href="#" class="ui basic label large margin-con-tp con-m-label">
                    方法论
                    <div class="detail">13</div>
                  </a>
                <a href="#" class="ui basic label large margin-con-tp con-m-label">
                    方法论
                    <div class="detail">13</div>
                  </a>
                <a href="#" class="ui basic label large margin-con-tp con-m-label">
                    方法论
                    <div class="detail">13</div>
                  </a>
                <a href="#" class="ui basic label large margin-con-tp con-m-label">
                    方法论
                    <div class="detail">13</div>
                  </a>
                <a href="#" class="ui basic label large margin-con-tp con-m-label">
                    方法论
                    <div class="detail">13</div>
                  </a>
                <a href="#" class="ui basic label large margin-con-tp con-m-label">
                    方法论
                    <div class="detail">13</div>
                  </a>
                <a href="#" class="ui basic label large margin-con-tp con-m-label">
                    方法论
                    <div class="detail">13</div>
                  </a>
                <a href="#" class="ui basic label large margin-con-tp con-m-label">
                    方法论
                    <div class="detail">13</div>
                  </a>
                <a href="#" class="ui basic label large margin-con-tp con-m-label">
                    方法论
                    <div class="detail">13</div>
                  </a>
                <a href="#" class="ui basic label large margin-con-tp con-m-label">
                    方法论
                    <div class="detail">13</div>
                  </a>
                <a href="#" class="ui basic label large margin-con-tp con-m-label">
                    方法论
                    <div class="detail">13</div>
                  </a>
                <a href="#" class="ui basic label large margin-con-tp con-m-label">
                    方法论
                    <div class="detail">13</div>
                  </a>
                <a href="#" class="ui basic label large margin-con-tp con-m-label">
                    方法论
                    <div class="detail">13</div>
                  </a>
                <a href="#" class="ui basic label large margin-con-tp con-m-label">
                    方法论
                    <div class="detail">13</div>
                  </a>
                <a href="#" class="ui basic label large margin-con-tp con-m-label">
                    方法论
                    <div class="detail">13</div>
                  </a>
                <a href="#" class="ui basic label large margin-con-tp con-m-label">
                    方法论
                    <div class="detail">13</div>
                  </a>
                <a href="#" class="ui basic label large margin-con-tp con-m-label">
                    方法论
                    <div class="detail">13</div>
                  </a>
                <a href="#" class="ui basic label large margin-con-tp con-m-label">
                    方法论
                    <div class="detail">13</div>
                  </a>
                <a href="#" class="ui basic label large margin-con-tp con-m-label">
                    方法论
                    <div class="detail">13</div>
                  </a>
            </div>

            <div class="ui top attached teal segment">
               <div class="ui padding-con-lr vertical segment">
                    <div class="ui mobile reversed stackable grid">
                        <div class="eleven wide column">
                            <h3 class="ui header">
                                title
                            </h3>
                            <p>内容</p>
                            <div class="ui stackable grid">

                               <div class="row">
                                  <div class="left aligned eleven wide column">
                                    <div class="ui horizontal link list">
                                        <div class="item">
                                            <img src="https://img2.baidu.com/it/u=3806232450,3077456550&fm=26&fmt=auto&gp=0.jpg" alt="" class="ui avatar image">
                                            <div class="content"><a href="#" class="header">name</a></div>
                                        </div>
                                        <div class="item">
                                            <i class="calendar icon"></i> 221-04-10
                                        </div>
                                        <div class="item">
                                            <i class="eye icon"></i> 123
                                        </div>
                                    </div>
                                </div>
                                <div class="right aligned five wide column">
                                    <a href="#" target="_blank" class="ui teal basic mini label">认知升级</a>
                                </div>
                               </div>
                                <div class="row">
                                  <div class="column">
                                  <a href="#" class="ui mini basic teal label">方法论</a>
                                  </div>
                                </div>
                            </div>
                        </div>
                        <div class="five wide column">
                            <a href="#" target="_blank">
                                <img src="https://img2.baidu.com/it/u=3806232450,3077456550&fm=26&fmt=auto&gp=0.jpg" alt="" class="ui rounded image">
                            </a>
                        </div>
                    </div>
                </div>
            </div>
             <div class="ui bottom attached segment">
                <div class="ui middle aligned two column grid">
                <div class="column left aligned">
                    <a href="#" class="ui teal basic mini button">上一页</a>
                </div>
                <div class="column right aligned">
                     <a href="#" class="ui teal basic mini button">下一页</a>
                </div>
              </div>
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
