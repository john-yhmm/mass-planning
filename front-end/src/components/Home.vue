<template>
  <v-container fluid class="rounded">
    <div v-for="(item, index) in labels" :key="index">
      <item :label="item"></item>
    </div>
  </v-container>
</template>

<script>
import Item from "./Item.vue";

export default {
  name: "Home",
  components: { Item },
  data: () => ({
    labels: [
      "Entrance hymn",
      "Kyrie",
      "Gloria",
      "Alleluia",
      "Credo",
      "Prayer of the faithful",
      "Offertory hymn",
      "Sanctus",
      "Our Father",
      "Agnus Dei",
      "Communion hymn",
      "Sending hymn",
    ],
  }),
};
</script>
