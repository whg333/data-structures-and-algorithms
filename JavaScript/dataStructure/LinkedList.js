function LinkedList(){
    this.header = null;
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
        var curr = this.header;
        if(curr == null){
            this.header = newNode;
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
        var indexPrevious = this._indexNodeAt(index-1);
        indexPrevious.next = new Node(element, indexPrevious.next);
        this.length++;
    },
    removeAt:function(index){
        this._checkIndex(index);
        var indexPrevious = this._indexNodeAt(index-1);
        indexPrevious.next = indexPrevious.next.next;
        this.length--;
    },
    indexAt:function(index){
        return this._indexNodeAt(index).element;
    },
    _indexNodeAt:function(index){
        this._checkIndex(index);
        var curr = this.header;
        for(var i=0;i<index;i++){
            curr = curr.next
        }
        return curr;
    },
    remove:function(element){
        var curr = this.header;
        if(curr == null) return false;

        var previous = this.header;
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
        var curr = this.header;
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
        this.header = null;
        this.length = 0;
    },
    size:function(){
        return this.length;
    },
    toString:function(){
        var eleStr = '';
        var curr = this.header;
        if(curr != null){
            eleStr += (curr.element);
            while(curr.next != null){
                eleStr += ', ';
                curr = curr.next;
                eleStr += (curr.element);
            }
        }
        return "LinkedList (elements=["+eleStr+"])";
    },
    _checkIndex:function(index){
        if(index < 0 || index > this.length-1){
            throw new Error("OutOfIndex : index="+index+", length="+this.length);
        }
    }
}