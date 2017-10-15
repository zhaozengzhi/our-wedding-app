Page({
    data: {
        imageUrl: "../../images/bless.jpg",
        bless:"祝福",
        user: "anonymous"
    },
    onReady: function(e){
        var that = this;
        wx.getUserInfo({
            success: function (res) {
                that.setData({user : res.userInfo.nickName})
            }
        })
    },
    sendBless: function(){
        wx.request({
            url: 'https://www.zhaozengzhi.cn/bless/add?user=' + this.data.user, 
            header: {
                'content-type': 'application/json'
            },
            success: function (res) {
                wx.showToast({
                    title: '感谢您的祝福',
                    icon: 'success',
                    duration: 2000
                });
            },
            fail: function(res){
                wx.showToast({
                    title: '服务器开小差啦',
                    icon: 'success',
                    duration: 2000
                })
            }
        })
    }
})