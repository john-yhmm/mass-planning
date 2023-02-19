<template>
  <v-container fluid class=" rounded">
    <v-row justify="center" v-for="n in 3" :key="n" no-gutters>
      <v-col cols="6" sm="5" md="4" lg="3">
        <v-sheet class="ma-2 pa-2">My Label</v-sheet>
      </v-col>
      <v-col cols="6" sm="5" md="4" lg="3">
        <v-text-field variant="underlined" hide-details></v-text-field>
      </v-col>
    </v-row>
</v-container>
</template>
<script>
export default {

}
</script>
