<template id="store-overview">
    <div>
        <h1>Stores</h1>
        <ul class="store-overview-list">
            <li v-for="store in stores">
                <a :href="`/stores/${store.name.trim()}`" class="link-to-store-details">
                    <div class="single-store-container" >
                        <h1>{{store.name}}</h1>

                        <img v-if="store.pictureUrl" class="cover-image-frontpage" v-bind:src="store.pictureUrl">
                        <img v-else class="cover-image-frontpage" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Icon-round-Question_mark.svg/480px-Icon-round-Question_mark.svg.png">
                    </div>
                </a>
            </li>
        </ul>
    </div>
</template>
<script>
    Vue.component("store-overview", {
        template: "#store-overview",
        data: () => ({
            stores: [],
        }),
        created() {
            fetch("/api/stores")
                .then(res => res.json())
                .then(res => {
                    this.stores = res;
                })
                .catch(() => alert("Error while fetching stores"));
        }
    });
</script>
<style>
    li{
        list-style-type: none;
    }

    .store-overview-list{
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
    }

    .store-overview-list li{
        padding: 10px;
        border: 1px solid white;
        border-radius: 15px;
    }

    .link-to-store-details{
        width: 400px;
        height:100px;
        text-decoration: none;
        color: white;
    }

    div.single-store-container{
        overflow: hidden;
        width: 500px;
        background-color: #000000;
        margin: 0 auto;
        opacity: 0.96;
        text-align: center;
    }

    div.single-store-container:hover{
        opacity: 1.0;
        overflow: hidden;
        -webkit-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        -moz-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
    }

    img.cover-image-frontpage {
        height: auto;
        width: 100%;
        padding-bottom: 20px;
        max-height: 280px;
    }

</style>