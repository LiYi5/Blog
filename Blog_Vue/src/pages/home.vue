<template>
  <div>
    <!-- 导航 -->
    <Header :cur="1"></Header>
    <!-- 中间内容 -->
    <div class="m-main-padded-tb">
      <div class="ui container">
        <div class="ui stackable grid">
          <!-- 右边内容 -->
          <div class="eleven wide column">
            <div class="ui top attached segment">
              <div class="ui middle aligned two column grid">
                <div class="column left aligned">
                  <h3 class="ui teal header">博客</h3>
                </div>
                <div class="column right aligned">
                  共
                  <h2 class="ui orange header m-inline-block">14</h2>
                  篇
                </div>
              </div>
            </div>
            <!-- 中间内容 -->
            <div class="ui attached segment">
                <div class="ui padding-con-lr vertical segment con-po">
                    <div class="ui mobile reversed stackable grid">
                        <div class="eleven wide column">
                            <h3 class="ui header">
                                title
                            </h3>
                            <p>内容</p>
                            <div class="ui grid  stackable">
                                <div class="left aligned eleven wide column">
                                    <div class="ui mini horizontal link list">
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
                        </div>
                        <div class="five wide column">
                            <a href="#" target="_blank">
                                <img src="https://img2.baidu.com/it/u=3806232450,3077456550&fm=26&fmt=auto&gp=0.jpg" alt="" class="ui rounded image">
                            </a>
                        </div>
                    </div>
                </div>
                <div class="ui padding-con-lr vertical segment">
                    <div class="ui mobile reversed stackable grid">
                        <div class="eleven wide column">
                            <h3 class="ui header">
                                title
                            </h3>
                            <p>内容</p>
                            <div class="ui stackable grid">
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
                        </div>
                        <div class="five wide column">
                            <a href="#" target="_blank">
                                <img src="https://img2.baidu.com/it/u=3806232450,3077456550&fm=26&fmt=auto&gp=0.jpg" alt="" class="ui rounded image">
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 底部-->
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
          <!-- 左边分类 -->
          <div class="five wide column">
            <div class="ui segments">
                <div class="ui secondary segment">
                  <div class="ui two column grid">
                    <div class="left aligned column"><i class="idea icon"></i>分类</div>
                    <div class="right aligned column">
                      <a href="#" target="_blank">more </a><i class="angle double right icon"></i>
                    </div>
                  </div>
                </div>
                <div class="ui left aligned teal segment">
                  <div class="ui fluid vertical menu">
                    <a href="#" class=" item">学习日志
                      <div class="ui label teal left pointing basic">13</div>
                    </a>
                    <a href="#" class=" item">学习日志
                      <div class="ui label teal left pointing basic">13</div>
                    </a>
                    <a href="#" class=" item">学习日志
                      <div class="ui label teal left pointing basic">13</div>
                    </a>
                    <a href="#" class=" item">学习日志
                      <div class="ui label teal left pointing basic">13</div>
                    </a>
                  </div>
                </div>
            </div>
            <!-- 标签 -->
                <div class="ui segments">
                <div class="ui secondary segment">
                  <div class="ui two column grid">
                    <div class="left aligned column"><i class="tags icon"></i>标签</div>
                    <div class="right aligned column">
                      <a href="#" target="_blank">more </a><i class="angle double right icon"></i>
                    </div>
                  </div>
                </div>
                <div class="ui left aligned teal segment">
                  <a href="#" class="ui teal basic label margin-con-tp">
                    方法论
                    <div class="detail">13</div>
                    </a>
                  <a href="#" class="ui teal basic label margin-con-tp">
                    方法论
                    <div class="detail">13</div>
                    </a>
                  <a href="#" class="ui teal basic label margin-con-tp">
                    方法论
                    <div class="detail">13</div>
                    </a>
                  <a href="#" class="ui teal basic label margin-con-tp">
                    方法论
                    <div class="detail">13</div>
                    </a>
                  <a href="#" class="ui teal basic label margin-con-tp">
                    方法论
                    <div class="detail">13</div>
                    </a>
                </div>
            </div>
            <!-- 最新推荐 -->
            <div class="ui segments">
                 <div class="ui secondary segment">
                  <div class="ui two column grid">
                    <div class="left aligned column"><i class="bookmark icon"></i>最新推荐</div>
                    <div class="right aligned column">
                    </div>
                  </div>
                 </div>
                  <div class="ui segment left aligned">
                    <a href="" target="_blank" class="black-text">用户故事（USer Story）</a>
                  </div>
                  <div class="ui segment left aligned">
                    <a href="" target="_blank" class="black-text">用户故事（USer Story）</a>
                  </div>
                  <div class="ui segment left aligned">
                    <a href="" target="_blank" class="black-text">用户故事（USer Story）</a>
                  </div>
                  <div class="ui segment left aligned">
                    <a href="" target="_blank" class="black-text">用户故事（USer Story）</a>
                  </div>
                  <div class="ui segment left aligned">
                    <a href="" target="_blank" class="black-text">用户故事（USer Story）</a>
                  </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- 底部 -->
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
    }
  },
  methods: {
  }
}
</script>

<style lang="less" scoped>
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
