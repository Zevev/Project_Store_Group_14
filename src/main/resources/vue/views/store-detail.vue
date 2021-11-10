<template id="store-detail">
    <div class="content-wrapper">
        <div class="grid">
        <div v-if="store" class="detail-store-container">
            <img v-if="store.pictureUrl" class="cover-image" v-bind:src="store.pictureUrl">
            <img v-else class="cover-image" src="https://i.pinimg.com/originals/cd/43/c1/cd43c186729dea89d16f7bbe03e434ec.jpg">

            {{console.log(this.store)}}

            <h1>{{store.name}}</h1>
            <p>Info about {{store.name}}.</p>
            <p><a class="button" class="add" :href="`/stores/${store.name}/createitem`">Create New Item</a></p>
        </div>

        <ul id="sortList">
            <li><a v-if="sorting" :href="`/stores/${store.name}?sort_by=name`">Sort alphabetically</a></li>
            <li><a v-if="sorting" :href="`/stores/${store.name}?sort_by=mass`">Sort by type</a></li>
            <li><a v-if="sorting" :href="`/stores/${store.name}?sort_by=num`">Sort by price</a></li>

        </ul>

        <ul class="item-overview-list">
            <li v-for="item in items">
                <a v-if="store" class="link-to-item-details" :href="`/stores/${store.name}/items/${item.name}`">
                    <div class="single-item-container" >
                        <h1>{{item.name}}</h1>
                        <img v-if="item.pictureUrl" class="list-image" v-bind:src="item.pictureUrl" style="float: left">
                        <img v-else class="list-image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Icon-round-Question_mark.svg/480px-Icon-round-Question_mark.svg.png" style="float: left">
                        <p>
                            Info about the item!
                        </p>
                    </div>
                </a>
            </li>
        </ul>
        </div>
    </div>
</template>
<script>
    Vue.component("store-detail", {
        template: "#store-detail",
        data: () => ({
            store: null,
            items: [],
            sorting: "name",
        }),
        created() {
            const storeId = this.$javalin.pathParams["store-id"];
            var sort = this.$javalin.queryParams["sort_by"];
            if (typeof sort != 'undefined')
                this.sorting = sort;
            fetch(`/api/stores/${storeId}`)
                .then(res => res.json())
                .then(res => {
                    this.store = res

                })
                .catch(() => alert("Error while fetching stores"))
            fetch(`/api/stores/${storeId}/items?sort_by=${this.sorting}`)
                .then(res => res.json())
                .then(res => this.items = res)
                .catch(() => alert("Error while fetching items"));
        }
    });
</script>
<style>

    .grid {
        display: grid;
        grid-template-columns: auto;
        grid-template-rows: auto;
        grid-template-areas: "header header header header"
        "sort list none none";

    }

    .item-overview-list{
        grid-area: list;
        color:black;

        justify-content: space-around;

    }

    #sortList{
        grid-area: sort;
        width: 200px;
        justify-content: center;
        margin-top: 30px;
        margin-bottom: 30px;
    }

    #sortList li{
        padding: 10px;
        margin: 10px;
        border: 1px solid white;
        color: white;
        border-radius: 15px;
        list-style-type: none;

    }

    #sortList li a{
        color: white;
        text-decoration: none;
        font-weight: bold;
    }

    #sortList li:hover{
        border: 2px solid white;
    }

    div.detail-store-container{
        grid-area: header;
        padding: 10px;
        overflow: hidden;
        width: 750px;
        margin: 0 auto;
        background-color: rgba(20, 20, 20, 0.98);
        opacity: 0.96;
        color: white;
        -webkit-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        -moz-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
    }

    div.single-item-container{
        overflow: hidden;
        color: white;
        background-color: rgba(0, 0, 0, 0.98);
        margin: 0 auto;
        opacity: 0.96;
        text-align: center;
    }

    .single-item-container{
       width: 500px;
    }


    div.single-item-container:hover{
        height:250px;
        opacity:1.0;

    }

    img.cover-image {
        height: auto;
        width: 50%;
        margin: 5px;
        float: left;
    }

    img.list-image {
        width: 140px;
        padding-bottom: 20px;
        transition: transform .2s;
    }

    .list-image:hover{
        transform: scale(1.1);
    }

    h1{
        font-size:18px;
        padding-top: 10px;
    }

    .link-to-item-details{
        width: 400px;
        height:100px;
        text-decoration: none;
        color:black;
    }

    .button {
        padding: 10px;
        margin: 10px;
        border: 1px solid white;
        color: white;
        border-radius: 15px;
    }

    button a{
        color: white;
        text-decoration: none;
        font-weight: bold;
    }

    .button:hover{
        border: 2px solid white;
    }


</style>
