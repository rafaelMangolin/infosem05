function Tree(){
	this.lines = [];
}

Tree.prototype.addFirst = function(vortex){
	this.lines.unshift(vortex);
}

Tree.prototype.removeFirst = function(){
	return this.lines.pop();
}

Tree.prototype.getSize = function(){
	return this.lines.length;
}

module.exports = Tree;