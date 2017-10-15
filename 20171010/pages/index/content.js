class Content {
  constructor(index, url, content, time){
    this.index = index
    this.url = url;
    this.content = content;
    this.time = time;
  }
};

Content.prototype.getIndex = function(){
  return this.index;
}

Content.prototype.getUrl = function(){
    return this.url;
}

Content.prototype.getContent = function(){
    return this.content;
}

Content.prototype.getTime = function(){
    return this.time;
}

module.exports = {
  Content: Content
}