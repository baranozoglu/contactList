<template>
  <el-table :data="data" style="width: 100%">
    <el-table-column prop="id" label="ID" width="180"> </el-table-column>
    <el-table-column width="100" height="100" prop="url" label="Url">
      <template slot-scope="scope">
        <img :src="scope.row.url" />
      </template>
    </el-table-column>
    <el-table-column prop="name" label="Name" width="180"> </el-table-column>
  </el-table>
</template>

<script>
export default {
  data: function() {
    return { 
      input: null,
    };
  },
  props: {
    data: {
      type: Array,
      required: false,
    },
  },
};
</script>
