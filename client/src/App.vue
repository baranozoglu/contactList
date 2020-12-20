<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png" />
    <HelloWorld msg="data" />
  </div>
</template>

<script>
import HelloWorld from "./components/HelloWorld.vue";
import axios from "axios";
export default {
  name: "App",
  components: {
    HelloWorld,
  },
  data() {
    return {
      data: null,
    };
  },
  mounted() {
    var header = {
      "Cache-Control": "no-cache",
      Pragma: "no-cache",
      "Axios-Call": "true",
      "Access-Control-Allow-Methods": "GET",
    };
    var params = {
      csvName: "people",
    };
    var url = "http://localhost:8080/contactList/upload";
    axios({
      url: url,
      method: "GET",
      responseType: "blob",
      data: params,
      headers: header,
    }).then((response) => (this.info = response.data.peopleList));
    // axios
    //     .get("http://localhost:8080/contactList/upload", config, params)
    //     .then((response) => (this.info = response))
    //     .then(
    //       axios
    //         .get("http://localhost:8080/contactList/people")
    //         .then((response) => (this.info = response.data.peopleList))
    //     );
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
