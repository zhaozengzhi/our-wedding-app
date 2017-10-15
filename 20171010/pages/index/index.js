import {
    ContentDetail
} from '../../const/const.js'
var content = require('content.js')
Page({
    data: {
        contents: [],
        current: 0
    },
    changeContent: function(e){
        let current = e.detail.current
        let contentSize = this.data.contents.length

        if (current === contentSize) {
            this.setData({
                current: this.data.contents.length -1
            })
        }
    },
    
    onReady: function (e) {
        this.backgroundAudioManager = wx.getBackgroundAudioManager()
        this.initBackupgroudMusic();
        this.loadContent();
    },

    initBackupgroudMusic: function () {
        this.backgroundAudioManager.title = 'Beautiful In White'
        this.backgroundAudioManager.epname = 'Beautiful In White'
        this.backgroundAudioManager.singer = 'Shane Filan'
        this.backgroundAudioManager.src = 'https://www.zhaozengzhi.cn/music/BeautifulInWhite.mp3'
    },

    loadContent: function () {
        var contents = [];
        for (var i in ContentDetail) {
            contents[i] = ContentDetail[i];
        }
        this.setData({
            contents: contents
        })
    }
})