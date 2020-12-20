<template>
  <el-table :data="data" style="width: 100%"  align="center" :header-row-style="{textAlign: 'center'}">
    <el-table-column prop="id" label="ID" width="180" align="center"> </el-table-column>
    <el-table-column max-width="100" max-height="100" align="center" prop="url" label="Url">
      <template slot-scope="scope">
        <img :src="scope.row.url" />
      </template>
    </el-table-column>
    <el-table-column prop="name" align="center" label="Name" width="200"> </el-table-column>
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
