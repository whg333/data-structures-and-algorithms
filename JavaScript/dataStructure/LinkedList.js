function LinkedList(){
    this.head = new Node(null, null);
    this.length = 0;
}

function Node(element, next){
    this.element = element;
    this.next = next;
}

LinkedList.prototype = {
    constructor:LinkedList,
    append:function(element){
        var newNode = new Node(element, null);
        var curr = this.head.next;
        if(curr == null){
            this.head.next = newNode;
        }else{
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = newNode;
        }
        this.length++;
    },
    insert:function(index, element){
        this._checkIndex(index);
        var previous = index == 0 ? this.head : this._indexNodeAt(index-1);
        previous.next = new Node(element, previous.next);
        this.length++;
    },
    removeAt:function(index){
        this._checkIndex(index);
        var previous = index == 0 ? this.head : this._indexNodeAt(index-1);
        var indexNode = previous.next;
        previous.next = previous.next.next;
        this.length--;
        return indexNode.element;
    },
    indexAt:function(index){
        return this._indexNodeAt(index).element;
    },
    _checkIndex:function(index){
        if(index < 0 || index >= this.length){
            throw new Error("indexOutOfBounds : index="+index+", length="+this.length);
        }
    },
    _indexNodeAt:function(index){
        this._checkIndex(index);
        var curr = this.head.next;
        for(var i=0;i<index;i++){
            curr = curr.next
        }
        return curr;
    },
    remove:function(element){
        //if(this.isEmpty()) return false;
        //var index = this.indexOf(element);
        //if(index < 0) return false;
        //this.removeAt(index);
        //return true;

        //上面使用indexOf和removeAt需要循环2次，而下面循环只需要1次
        var curr = this.head.next;
        if(curr == null) return false;

        var previous = this.head;
        for(var i=0;curr!=null;i++){
            if(curr.element == element){
                previous.next = curr.next;
                this.length--;
                return true;
            }
            previous = curr;
            curr = curr.next;
        }
        return false;
    },
    indexOf:function(element){
        var curr = this.head.next;
        if(curr == null) return -1;

        for(var i=0;curr!=null;i++){
            if(curr.element == element){
                return i;
            }
            curr = curr.next;
        }
        return -1;
    },
    isEmpty:function(){
        return this.length == 0;
    },
    clear:function(){
        this.head.next = null;
        this.length = 0;
    },
    size:function(){
        return this.length;
    },
    toString:function(){
        var eleStr = '';
        var curr = this.head.next;
        while(curr != null){
            eleStr += curr.element;
            if(curr.next != null){
                eleStr += ', ';
            }
            curr = curr.next;
        }
        return "LinkedList (elements=["+eleStr+"])";
    }
}