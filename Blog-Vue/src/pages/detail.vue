<template>
  <div>
    <Header></Header>
    <div class="ui container blank-top left aligned">
      <div class="ui top attached segment">
        <div class="ui horizontal link list">
          <div class="item">
            <img
              src="https://img2.baidu.com/it/u=3806232450,3077456550&fm=26&fmt=auto&gp=0.jpg"
              alt=""
              class="ui avatar image"
            />
            <div class="content"><a href="#" class="header">name</a></div>
          </div>
          <div class="item"><i class="calendar icon"></i> 221-04-10</div>
          <div class="item"><i class="eye icon"></i> 123</div>
        </div>
      </div>
      <div class="ui attached segment">
        <img
          src="https://img2.baidu.com/it/u=3806232450,3077456550&fm=26&fmt=auto&gp=0.jpg"
          alt=""
          class="ui fluid rounded image"
        />
      </div>
      <div class="ui attached segment">
        <div class="ui right aligned basic segment">
          <div class="ui label orange basic">原创</div>
        </div>
        <h2 class="ui header center aligned">生活感悟</h2>
        <div id="content" class="con-content">
          有一次看了一梦想家的节目，里面的那位主人公说：“儿童摄影就是用相机记录孩子的成长”。因为老公也喜欢摄影，我便对老公点评这句话说得好。接着我又问他：“你没事时也喜欢咔嚓两下，你觉得怎样才算一个好的摄影师？”没想到老公的几句话，让我有了一番不小的感悟。<br /><br />他是这么说的：对于一个好的摄影师来说，技术是基础，最重要的是要有一颗发现美的眼睛。而有发现美的眼睛需要这个摄影师热爱生活。生活中到处都有美的风景，唯有热爱生活，才能善于发现生活中的美丽，也才能在瞬间构图出有创意与美感的片子出来。<br /><br />他说完时，我想起了他喜欢拍晴空朗朗，雾霾重重，他喜欢拍劳苦的脸，清澈的眼。他拍白云，大海，田野，高楼。他拍他穿得磨破了的裤子，跟随了他很多年的杯子。春秋时节，他喜欢避开人群熙攘，带着我和孩子去荒郊野外静静地拍摄春花秋叶。在家中时，他拍跟孩子或疯闹或温情的时刻。<br /><br />而所有的这一切，在我眼中都是习以为常地不能再普通的景物，而在他眼中，他却欣赏得兴趣盎然，拍得不亦乐乎。他对着一片破砖烂瓦咔嚓个不停，我撇着嘴：“这有什么好拍的？”可他说：“我拍的不是砖瓦，而是砖瓦背后的历史。这样的建筑，用现代的技术，能建设得更好。可是这建筑里所沉淀的历史，却是真正有意义的东西。”<br /><br />哦，原来如此。我突然发现，原来每一个摄影师不是在拍别人，而是在拍自己。透过照片，有心的人，能看到他们对生活的热爱与表达。而这些东西对一个摄影师来说才是真正有价值的体现。<br /><br />我们熟悉我们的日常生活，就像熟悉我们的指纹一样，我们知道它每天存在着，可是又有几个人用心感受着它每时每刻的存在？<br /><br />同理，我想到了我喜欢写作这件事情。一次一朋友问我：“你为什么喜欢写？”我当时随口告诉她我就是习惯了。而我确实也认为我写东西就是个习惯问题。从初中开始我有了写日记的习惯，后来一直写到大学。毕业工作后我又养成了写博客的习惯，时至今日，我仍不停地写着。可是今天当我带着深刻的态度问自己为什么喜欢写时，我忽然想起了一件事情：<br /><br />国庆节放假回家，我偶然间翻开妈妈一直给我保存的一摞子日记本，我随手翻开一页，里面叙述了一件事情是我们的初中班长邢佑明在讲台给大家唱花仙子那首歌。我在日记中描述他一边唱一边用腿打着节奏，唱得很好听，好像一个阳光大男孩。然后我又随手翻了几页，有记录着我语文辩论赛上精彩的瞬间；有我和哥哥吵架后，他为了哄我开心，骑车去给我买本子，却差点被汽车撞到的惊险，有我心疼爸爸一天天地劳累变老，给爸爸写的小诗……我发现如果不是日记，这些我生活过的往事，带给我感动的时刻，恐怕我一辈子也不会记起。<br /><br />慢慢地，我似乎找到了我心底的答案：我们的昨天都是今天的历史。历史就像一道黑暗而幽深的隧道，照不到光的地方就在历史的黑暗中沉沦，永远的沉沦。而我的文字就像黑暗中的一束光，每每当我回头寻找我的历史时，它就会在黑暗中璀璨起来，让我清晰地触摸到我历史中那些触动过我的美好时刻。<br /><br />由此，我写天，写地，写别人，写自己，归根结底，都是在写我自己。所以，我想，我应该也是热爱生活的，也一直在用心感受并记录着我热爱生活这件事。所以，写作，不为别的，只为热爱。既然热爱了，那总得对得起这份热爱吧。
        </div>
        <div class="con-label">
          <div class="ui basic teal label">方法论</div>
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
</style>
