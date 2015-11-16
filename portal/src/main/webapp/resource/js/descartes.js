var Descartes = {
	globalList : "",
	descartes : function(list) {
		globalList = list;
		for ( var p in globalList) {
			return this.preCross(globalList[p], p);
			break;
		}
	},
	preCross : function(result, point) {
		var flag = false;
		for ( var p in globalList) {
			if (flag) {
				point = p;
				result = this.cross(result, globalList[point]);
				return this.preCross(result, point);
				break;
			}
			if (p == point) {
				flag = true;
				continue;
			}
		}
		return result;
	},
	cross : function(listA, listB) {
		var tempList = new Array();
		for ( var a in listA) {
			for ( var b in listB) {
				
				tempList.push(listA[a].concat(listB[b]));
			}
		}
		return tempList;
	}
}
