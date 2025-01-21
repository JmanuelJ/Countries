package com.juanma.exercise.countries.data.networking.model

import com.google.gson.annotations.SerializedName

data class ResponseApi(
    @SerializedName("altSpellings")val altSpellings: List<String>,
    @SerializedName("area")val area: Int,
    @SerializedName("borders")val borders: List<String>,
    @SerializedName("capital")val capital: List<String>,
    @SerializedName("capitalInfo")val capitalInfo: CapitalInfo,
    @SerializedName("car")val car: Car,
    @SerializedName("cca2")val cca2: String,
    @SerializedName("cca3")val cca3: String,
    @SerializedName("ccn3")val ccn3: String,
    @SerializedName("cioc")val cioc: String,
    @SerializedName("coatOfArms")val coatOfArms: CoatOfArms,
    @SerializedName("continents")val continents: List<String>,
    @SerializedName("currencies")val currencies: Currencies,
    @SerializedName("Function…")val demonyms: Demonyms,
    @SerializedName("fifa")val fifa: String,
    @SerializedName("flag")val flag: String,
    @SerializedName("flags")val flags: Flags,
    @SerializedName("gini")val gini: Gini,
    @SerializedName("idd")val idd: Idd,
    @SerializedName("independent")val independent: Boolean,
    @SerializedName("landlocked")val landlocked: Boolean,
    @SerializedName("languages")val languages: Languages,
    @SerializedName("latlng")val latLng: List<Float>,
    @SerializedName("maps")val maps: Maps,
    @SerializedName("name")val name: Name,
    @SerializedName("population")val population: Int,
    @SerializedName("postalCode")val postalCode: PostalCode,
    @SerializedName("region")val region: String,
    @SerializedName("startOfWeek")val startOfWeek: String,
    @SerializedName("status")val status: String,
    @SerializedName("subregion")val subregion: String,
    @SerializedName("timezones")val timezones: List<String>,
    @SerializedName("tld")val tld: List<String>,
    @SerializedName("translations")val translations: Map<String, NativeNameDetail>,
    @SerializedName("unMember")val unMember: Boolean
)

data class ResponseCountryItem(
    @SerializedName("flags")val flags: Flags,
    @SerializedName("name")val name: Name
)

data class CapitalInfo(
    @SerializedName("latlng") val latLng: List<Double>
)

data class Car(
    @SerializedName("side")val side: String,
    @SerializedName("signs")val signs: List<String>
)

data class CoatOfArms(
    @SerializedName("png")val png: String,
    @SerializedName("svg")val svg: String
)
data class Currencies(
    @SerializedName("MDL")val mdl: MDL
)

data class Demonyms(
    @SerializedName("eng")val eng: Eng,
    @SerializedName("fra")val fra: Fra
)

data class Eng(
    @SerializedName("f")val f: String,
    @SerializedName("m")val m: String
)

data class Flags(
    @SerializedName("alt")val alt: String,
    @SerializedName("png")val png: String,
    @SerializedName("svg")val svg: String
)

data class Fra(
    @SerializedName("f")val f: String,
    @SerializedName("m")val m: String
)

data class Gini(
    @SerializedName("`2018`")val gini: Double
)

data class Idd(
    @SerializedName("root")val root: String,
    @SerializedName("suffixes")val suffixes: List<String>
)

data class Languages(
    @SerializedName("ron")val ron: String
)

data class Maps(
    @SerializedName("googleMaps")val googleMaps: String,
    @SerializedName("openStreetMaps")val openStreetMaps: String
)

data class MDL(
    @SerializedName("name")val name: String,
    @SerializedName("symbol")val symbol: String
)

data class Name(
    @SerializedName("common")val common: String,
    @SerializedName("nativeName")val nativeName: Map<String, NativeNameDetail>,
    @SerializedName("official")val official: String
)

data class NativeNameDetail(
    @SerializedName("common")val common: String,
    @SerializedName("official")val official: String
)

data class PostalCode(
    @SerializedName("format")val format: String,
    @SerializedName("regex")val regex: String
)

