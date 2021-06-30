package com.example.loadmoreexample

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class HomeCashBack : Serializable {
    @SerializedName("id")
    @Expose
    val id: Int? = null

    @SerializedName("name")
    @Expose
    val name: String? = null

    @SerializedName("owner_id")
    @Expose
    val ownerId: Int? = null

    @SerializedName("address")
    @Expose
    val address: String? = null

    @SerializedName("lat")
    @Expose
    val lat: Any? = null

    @SerializedName("lng")
    @Expose
    val lng: Any? = null

    @SerializedName("province_id")
    @Expose
    val provinceId: String? = null

    @SerializedName("district_id")
    @Expose
    val districtId: String? = null

    @SerializedName("ward_id")
    @Expose
    val wardId: String? = null

    @SerializedName("number_rooms")
    @Expose
    val numberRooms: Int? = null

    @SerializedName("status")
    @Expose
    val status: Int? = null

    @SerializedName("status_confirm")
    @Expose
    val statusConfirm: Int? = null

    @SerializedName("type")
    @Expose
    val type: Int? = null

    @SerializedName("electric_price")
    @Expose
    val electricPrice: Int? = null

    @SerializedName("water_price")
    @Expose
    val waterPrice: Int? = null

    @SerializedName("collaborator_id")
    @Expose
    val collaboratorId: Any? = null

    @SerializedName("desc")
    @Expose
    val desc: String? = null

    @SerializedName("created_at")
    @Expose
    val createdAt: String? = null

    @SerializedName("updated_at")
    @Expose
    val updatedAt: String? = null

    @SerializedName("deleted_at")
    @Expose
    val deletedAt: Any? = null

    @SerializedName("collect")
    @Expose
    val collect: Int? = null

    @SerializedName("spend")
    @Expose
    val spend: Int? = null

    @SerializedName("image")
    @Expose
    val image: String? = null

    @SerializedName("phone")
    @Expose
    val phone: Any? = null

    @SerializedName("number_floors")
    @Expose
    val numberFloors: Any? = null

    @SerializedName("number_empty_rooms")
    @Expose
    val numberEmptyRooms: Int? = null

    @SerializedName("images")
    @Expose
    val images: Any? = null

    @SerializedName("avg_ratings")
    @Expose
    val avgRatings: Int? = null

    @SerializedName("number_empty_room")
    @Expose
    val numberEmptyRoom: Int? = null

    @SerializedName("is_featured")
    @Expose
    val isFeatured: Int? = null

    @SerializedName("expire_featured")
    @Expose
    val expireFeatured: Any? = null

    @SerializedName("owner_name")
    @Expose
    val ownerName: String? = null

    @SerializedName("owner_id_number")
    @Expose
    val ownerIdNumber: String? = null

    @SerializedName("owner_phone")
    @Expose
    val ownerPhone: String? = null

    @SerializedName("owner_email")
    @Expose
    val ownerEmail: String? = null

    @SerializedName("type_rent")
    @Expose
    val typeRent: Int? = null

    @SerializedName("date_ew")
    @Expose
    val dateEw: Any? = null

    @SerializedName("date_money")
    @Expose
    val dateMoney: Any? = null

    @SerializedName("source")
    @Expose
    val source: Int? = null

    @SerializedName("is_display")
    @Expose
    val isDisplay: Int? = null

    @SerializedName("hotline")
    @Expose
    val hotline: Any? = null

    @SerializedName("user_hotline")
    @Expose
    val userHotline: Any? = null

    @SerializedName("smallest_price")
    @Expose
    val smallestPrice: Int? = null

    @SerializedName("greatest_price")
    @Expose
    val greatestPrice: Int? = null

    @SerializedName("note")
    @Expose
    val note: Any? = null

    @SerializedName("is_verify")
    @Expose
    val isVerify: Int? = null

    @SerializedName("sort_price")
    @Expose
    val sortPrice: Any? = null

    @SerializedName("min_price")
    @Expose
    val minPrice: Long? = null

    @SerializedName("max_price")
    @Expose
    val maxPrice: Long? = null

    @SerializedName("dynamic_link")
    @Expose
    val dynamicLink: String? = null

    @SerializedName("number_beds")
    @Expose
    val numberBeds: Int? = null

    @SerializedName("cashback")
    @Expose
    val cashback: Long? = null

    @SerializedName("number_follows")
    @Expose
    val numberFollows: Int? = null

    @SerializedName("size")
    @Expose
    val size: Int? = null


    override fun equals(other: Any?): Boolean {
        var result = false
        if (other is HomeCashBack) result = id == other.id
        return result
    }
}