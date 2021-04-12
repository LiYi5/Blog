<template>
  <div class="ui inverted vertical segment m-padding-tb">
      <div class="ui center aligned contaner lr-padd ">
          <div class="ui  stackable inverted divided grid">
              <div class="three wide column">
                  <img src="../assets/lf.jpg" class="ui rounded img_size" alt="">
              </div>
              <div class="four wide column text_opacity">
                  <h5 class="ui inverted header">最新内容</h5>
                  <div class="ui inverted link list text-linehight">
                      <a href="#" class="item">1</a>
                      <a href="#" class="item">2</a>
                      <a href="#" class="item">3</a>
                  </div>
              </div>
              <div class="four wide column text_opacity">
                     <h5 class="ui inverted header">路   飞</h5>
                  <p  class="text-linehight">如果放弃我终生遗憾</p>
                   <p class="text-linehight">我是要成为海贼王的男人</p>
                  <p class="text-linehight">战胜你的话我就保护不了任何人</p>
              </div>
              <div class="five wide column text_opacity ">
                     <h5 class="ui inverted header">Fighting</h5>
                     <p class="text-linehight">多一分快怡 少一分忧伤</p>
                     <p class="text-linehight">多一分真实 少一分虚伪</p>
                     <p class="text-linehight">多一分悠闲 少一分忙乱</p>
                  </div>
              </div>
          </div>
      </div>
</template>

<script>
export default {

}
</script>

<style lang="less">
.m-padding-tb{
    padding-top: 3em!important;
    padding-bottom: 3em!important;
}
.lr-padd{
    margin: 0 100px;
}
.img_size{
    width: 150px;
    padding-top:10px
}
.text_opacity{
    opacity: 0.8!important;
}
.text-linehight{
    line-height: 1em;
}
</style>
