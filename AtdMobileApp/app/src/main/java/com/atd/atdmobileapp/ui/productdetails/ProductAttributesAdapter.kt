package com.atd.atdmobileapp.ui.productdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.databinding.FragmentProductAttributesBinding
import com.atd.atdmobileapp.models.keywordsearch.Product
import com.atd.atdmobileapp.ui.productdetails.ProductDetailsFragment.Companion.tvDimentions
import com.atd.atdmobileapp.ui.productdetails.ProductDetailsFragment.Companion.tvFinish
import com.atd.atdmobileapp.ui.productdetails.ProductDetailsFragment.Companion.tvFitment
import com.atd.atdmobileapp.ui.productdetails.ProductDetailsFragment.Companion.tvLugs
import com.atd.atdmobileapp.ui.productdetails.ProductDetailsFragment.Companion.tvPerformance
import com.atd.atdmobileapp.ui.productdetails.ProductDetailsFragment.Companion.tvPrecision
import com.atd.atdmobileapp.ui.productdetails.ProductDetailsFragment.Companion.tvProductInformation
import com.atd.atdmobileapp.ui.productdetails.ProductDetailsFragment.Companion.tvSafety
import com.atd.atdmobileapp.ui.productdetails.ProductDetailsFragment.Companion.tvSize
import com.atd.atdmobileapp.ui.productdetails.ProductDetailsFragment.Companion.tvWeather
import com.atd.atdmobileapp.ui.productdetails.ProductDetailsFragment.Companion.tvWheelHub
import com.atd.atdmobileapp.utils.gone
import com.atd.atdmobileapp.utils.visible

class ProductAttributesAdapter(
    val requireActivity: FragmentActivity,
    val listOfData: ArrayList<String>,
    val product: Product,
    val productGroupType: String
) : RecyclerView.Adapter<ProductAttributesAdapter.DataViewHolder>() {


    class DataViewHolder(val binding: FragmentProductAttributesBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(itemname: String, product: Product, productGroupType: String) {


            binding.item.text = itemname

            if (itemname.lowercase().equals("product width", true)) {
                binding.itemValue.text = product?.productspec?.productwidth?.toString()
                if (!binding.itemValue.text.toString().equals("")) tvDimentions.visible()
            }
            if (itemname.lowercase().equals("product length", true)) {
                binding.itemValue.text = product?.productspec?.productlength?.toString()
                if (!binding.itemValue.text.toString().equals("")) tvDimentions.visible()
            }
            if (itemname.lowercase().equals("product height", true)) {
                binding.itemValue.text = product?.productspec?.productheight?.toString()
                if (!binding.itemValue.text.toString().equals("")) tvDimentions.visible()
            }
            if (itemname.lowercase().equals("size", true)) {
                binding.itemValue.text = product?.productspec?.size?.toString()
                if (!binding.itemValue.text.toString().equals("")) tvSize.visible()
            }

            if (productGroupType.equals("wheel", true) || productGroupType.equals("tire", true)) {


                // dimensions
                if (itemname.lowercase().equals("wheel diameter", true)) {
                    binding.itemValue.text = product?.productspec?.wheeldiameter?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvDimentions.visible()
                }

                if (itemname.lowercase().equals("lip width", true)) {
                    binding.itemValue.text = product?.productspec?.lipwidth?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvDimentions.visible()
                }
                if (itemname.lowercase().equals("wheel width", true)) {
                    binding.itemValue.text = product?.productspec?.wheelwidth?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvDimentions.visible()
                }
                if (itemname.lowercase().equals("tire width", true)) {
                    binding.itemValue.text = product?.productspec?.tirewidth?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvDimentions.visible()
                }
                if (itemname.lowercase().equals("Aspect Ratio", true)) {
                    binding.itemValue.text = product?.productspec?.aspectratio?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvDimentions.visible()
                }
                if (itemname.lowercase().equals("tire diameter", true)) {
                    binding.itemValue.text = product?.productspec?.tirediameter?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvDimentions.visible()
                }
                if (itemname.lowercase().equals("overall tire diameter", true)) {
                    binding.itemValue.text = product?.productspec?.overalltirediameter?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvDimentions.visible()
                }
                if (itemname.lowercase().equals("outer diameter", true)) {
                    binding.itemValue.text = product?.productspec?.outerdiameter?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvDimentions.visible()
                }
                if (itemname.lowercase().equals("tire wheel size", true)) {
                    binding.itemValue.text = product?.productspec?.tirewheelsize?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvDimentions.visible()
                }

                if (itemname.lowercase().equals("rim diameter", true)) {
                    binding.itemValue.text = product?.productspec?.rimdiameter?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvDimentions.visible()
                }
                if (itemname.lowercase().equals("minimum rim width", true)) {
                    binding.itemValue.text = product?.productspec?.minrimwidth?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvDimentions.visible()
                }
                if (itemname.lowercase().equals("maximum rim width", true)) {
                    binding.itemValue.text = product?.productspec?.maxrimwidth?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvDimentions.visible()
                }
                if (itemname.lowercase().equals("maximum rim width", true)) {
                    binding.itemValue.text = product?.productspec?.maxrimwidth?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvDimentions.visible()
                }
                if (itemname.lowercase().equals("model number", true)) {
                    binding.itemValue.text = product?.productspec?.miscmodelnumber?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvDimentions.visible()
                }
                if (itemname.lowercase().equals("size", true)) {
                    binding.itemValue.text = product?.productspec?.size?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvDimentions.visible()
                }


                //Fitment
                if (itemname.lowercase().equals("bolt pattern", true)) {
                    val boltpattern =
                        product?.productspec?.boltpattern1?.toString() + " " + product?.productspec?.boltpattern2?.toString() + " " + product?.productspec?.boltpattern3?.toString() + " " + product?.productspec?.boltpattern4?.toString() + " "
                    binding.itemValue.text = boltpattern.replace("null", "").trim()
                    if (!binding.itemValue.text.toString().isNullOrEmpty()) {
                        tvFitment.visible()
                    }
                }
                if (itemname.lowercase().equals("bolt circle", true)) {
                    binding.itemValue.text = product?.productspec?.boltcircle?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvFitment.visible()
                }
                if (itemname.lowercase().equals("wheel bolt circle", true)) {
                    binding.itemValue.text = product?.productspec?.wheelboltcircle?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvFitment.visible()
                }
                if (itemname.lowercase().equals("offset", true)) {
                    binding.itemValue.text = product?.productspec?.offset?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvFitment.visible()
                }
                if (itemname.lowercase().equals("offset description", true)) {
                    binding.itemValue.text = product?.productspec?.offsetdescription?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvFitment.visible()
                }
                if (itemname.lowercase().equals("backspacing", true)) {
                    binding.itemValue.text = product?.productspec?.backspacing?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvFitment.visible()
                }


                //Performance
                if (itemname.lowercase().equals("warranty", true)) {
                    binding.itemValue.text = product?.productspec?.warrantynotes?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvPerformance.visible()
                }
                if (itemname.lowercase().equals("load rating (lbs)", true)) {
                    binding.itemValue.text = product?.productspec?.loadrating?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvPerformance.visible()
                }
                if (itemname.lowercase().equals("UTQG", true)) {
                    binding.itemValue.text = product?.productspec?.utqggl?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvPerformance.visible()
                }
                if (itemname.lowercase().equals("Sidewall", true)) {
                    binding.itemValue.text = product?.productspec?.sidewall?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvPerformance.visible()
                }
                if (itemname.lowercase().equals("speed rating", true)) {
                    binding.itemValue.text = product?.productspec?.speedrating?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvPerformance.visible()
                }
                if (itemname.lowercase().equals("tire ply", true)) {
                    binding.itemValue.text = product?.productspec?.tireply?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvPerformance.visible()
                }

                if (itemname.lowercase().equals("temperature rating", true)) {
                    binding.itemValue.text = product?.productspec?.temperaturerating?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvPerformance.visible()
                }
                if (itemname.lowercase().equals("treadwear", true)) {
                    binding.itemValue.text = product?.productspec?.treadwear?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvPerformance.visible()
                }
                if (itemname.lowercase().equals("maximum speed", true)) {
                    binding.itemValue.text = product?.productspec?.maxspeed?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvPerformance.visible()
                }
                if (itemname.lowercase().equals("mileage warranty", true)) {
                    binding.itemValue.text = product?.productspec?.mileagewarranty?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvPerformance.visible()
                }
                if (itemname.lowercase().equals("mileage warranty", true)) {
                    binding.itemValue.text = product?.productspec?.mileagewarranty?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvPerformance.visible()
                }


                //Finish
                if (itemname.lowercase().equals("atd finish", true)) {
                    binding.itemValue.text = product?.productspec?.atdfinish?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvFinish.visible()
                }
                if (itemname.lowercase().equals("manufacturer finish", true)) {
                    binding.itemValue.text = product?.productspec?.mfgfinish?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvFinish.visible()
                }
                if (itemname.lowercase().equals("material", true)) {
                    binding.itemValue.text = product?.productspec?.material?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvFinish.visible()
                }

                //Wheel Hub
                if (itemname.lowercase().equals("hub bore", true)) {
                    binding.itemValue.text = product?.productspec?.hubbore?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvWheelHub.visible()
                }
                if (itemname.lowercase().equals("hub centric", true)) {
                    binding.itemValue.text = product?.productspec?.hubcentricflag?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvWheelHub.visible()
                }
                if (itemname.lowercase().equals("Hub Centric Ring Included", true)) {
                    binding.itemValue.text =
                        product?.productspec?.hubcentrcringcincludedflag?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvWheelHub.visible()
                }

                //Lugs
                if (itemname.lowercase().equals("# of lug holes", true)) {
                    binding.itemValue.text = product?.productspec?.numberoflugholes?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvLugs.visible()
                }
                if (itemname.lowercase().equals("lug nut type", true)) {
                    binding.itemValue.text = product?.productspec?.lugnuttype?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvLugs.visible()
                }
                if (itemname.lowercase().equals("wheel lugs", true)) {
                    binding.itemValue.text = product?.productspec?.wheellugs?.toString()
                    if (!binding.itemValue.text.toString().equals("")) tvLugs.visible()
                }


                //Product Information
                if (itemname.lowercase().equals("style", true)) {
                    binding.itemValue.text = product?.productspec?.wheelstyle?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("upc", true)) {
                    binding.itemValue.text = product?.productspec?.upc?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("wcountry of origin", true)) {
                    binding.itemValue.text = product?.productspec?.countryoforigin?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("msrp", true)) {
                    binding.itemValue.text = product?.productspec?.msrp?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("map", true)) {
                    binding.itemValue.text = product?.productspec?.map?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("staggered", true)) {
                    binding.itemValue.text = product?.productspec?.staggeredflag?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("replacement part number", true)) {
                    binding.itemValue.text =
                        product?.productspec?.replacementcappartnumber?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("special notes", true)) {
                    binding.itemValue.text = product?.productspec?.specialnotes?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("item sub-group", true)) {
                    binding.itemValue.text = product?.productspec?.itemsubgroup?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("shipping weight", true)) {
                    binding.itemValue.text = product?.productspec?.shippingweight?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("assembly", true)) {
                    binding.itemValue.text = product?.productspec?.assemblyflag?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("oe markings", true)) {
                    binding.itemValue.text = product?.productspec?.oemarkings?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("set code", true)) {
                    binding.itemValue.text = product?.productspec?.setcode?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("set flap", true)) {
                    binding.itemValue.text = product?.productspec?.setflapflag?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("smart way designation", true)) {
                    binding.itemValue.text = product?.productspec?.smartwaydesignation?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("set tubes and flap", true)) {
                    binding.itemValue.text = product?.productspec?.settubesandflapflag?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }

                if (itemname.lowercase().equals("tread depth",true)){
                    binding.itemValue.text = product?.productspec?.treaddepth?.toString()
                    if(!binding.itemValue.text.toString().equals("")) tvPrecision.visible()
                }
                if (itemname.lowercase().equals("radial bias",true)){
                    binding.itemValue.text = product?.productspec?.radialbiasflag?.toString()
                    if(!binding.itemValue.text.toString().equals("")) tvPrecision.visible()
                }
                if (itemname.lowercase().equals("asymmetrical",true)){
                    binding.itemValue.text = product?.productspec?.asymmetrical?.toString()
                    if(!binding.itemValue.text.toString().equals("")) tvPrecision.visible()
                }
                if (itemname.lowercase().equals("directional",true)){
                    binding.itemValue.text = product?.productspec?.directional?.toString()
                    if(!binding.itemValue.text.toString().equals("")) tvPrecision.visible()
                }

                //Safety
                if (itemname.lowercase().equals("load index",true)){
                    binding.itemValue.text = product?.productspec?.loadindex?.toString()
                    if(!binding.itemValue.text.toString().equals("")) tvSafety.visible()
                }
                if (itemname.lowercase().equals("load rating",true)){
                    binding.itemValue.text = product?.productspec?.loadrating?.toString()
                    if(!binding.itemValue.text.toString().equals("")) tvSafety.visible()
                }
                if (itemname.lowercase().equals("load range",true)){
                    binding.itemValue.text = product?.productspec?.loadrange?.toString()
                    if(!binding.itemValue.text.toString().equals("")) tvSafety.visible()
                }
                if (itemname.lowercase().equals("traction rating",true)){
                    binding.itemValue.text = product?.productspec?.tractionrating?.toString()
                    if(!binding.itemValue.text.toString().equals("")) tvSafety.visible()
                }
                if (itemname.lowercase().equals("rpm",true)){
                    binding.itemValue.text = product?.productspec?.rpm?.toString()
                    if(!binding.itemValue.text.toString().equals("")) tvSafety.visible()
                }
                if (itemname.lowercase().equals("maximum tire pressure",true)){
                    binding.itemValue.text = product?.productspec?.maxtirepressure?.toString()
                    if(!binding.itemValue.text.toString().equals("")) tvSafety.visible()
                }
                if (itemname.lowercase().equals("speed maximum tire pressure",true)){
                    binding.itemValue.text = product?.productspec?.speedmaxtirepressure?.toString()
                    if(!binding.itemValue.text.toString().equals("")) tvSafety.visible()
                }
                if (itemname.lowercase().equals("run flat",true)){
                    binding.itemValue.text = product?.productspec?.runflat?.toString()
                    if(!binding.itemValue.text.toString().equals("")) tvSafety.visible()
                }
                if (itemname.lowercase().equals("single maximum load (lbs)",true)){
                    binding.itemValue.text = product?.productspec?.singlemaxloadlbs?.toString()
                    if(!binding.itemValue.text.toString().equals("")) tvSafety.visible()
                }
                if (itemname.lowercase().equals("single maximum load (lbs)",true)){
                    binding.itemValue.text = product?.productspec?.singlemaxloadlbs?.toString()
                    if(!binding.itemValue.text.toString().equals("")) tvSafety.visible()
                }
                if (itemname.lowercase().equals("dual maximum load (lbs)",true)){
                    binding.itemValue.text = product?.productspec?.dualmaxloadlbs?.toString()
                    if(!binding.itemValue.text.toString().equals("")) tvSafety.visible()
                }
                if (itemname.lowercase().equals("Tubeless?",true)){
                    binding.itemValue.text = product?.productspec?.tubelessflag?.toString()
                    if(!binding.itemValue.text.toString().equals("")) tvSafety.visible()
                }
                //Weather
                if (itemname.lowercase().equals("seasonal designation?",true)){
                    binding.itemValue.text = product?.productspec?.seasonaldesignation?.toString()
                    if(!binding.itemValue.text.toString().equals("")) tvWeather.visible()
                }
                if (itemname.lowercase().equals("winter designation",true)){
                    binding.itemValue.text = product?.productspec?.winterdesignation?.toString()
                    if(!binding.itemValue.text.toString().equals("")) tvWeather.visible()
                }
                if (itemname.lowercase().equals("winter stud size",true)){
                    binding.itemValue.text = product?.productspec?.winterstudsize?.toString()
                    if(!binding.itemValue.text.toString().equals("")) tvWeather.visible()
                }


            }

            if (productGroupType.equals("Caps", true)){
                if (itemname.lowercase().equals("bolt pattern", true)) {
                    binding.itemValue.text = product?.productspec?.capsboltpattern?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
            if (itemname.lowercase().equals("finish", true)) {
                binding.itemValue.text = product?.productspec?.capsfinish?.toString()
                if (!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.lowercase().equals("height", true)) {
                binding.itemValue.text = product?.productspec?.capsheight?.toString()
                if (!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.lowercase().equals("inside diameter", true)) {
                binding.itemValue.text = product?.productspec?.capsinsidediameter?.toString()
                if (!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.lowercase().equals("outside diameter", true)) {
                binding.itemValue.text = product?.productspec?.capsoutsidediameter?.toString()
                if (!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.lowercase().equals("install method", true)) {
                binding.itemValue.text = product?.productspec?.capsinstallmethod?.toString()
                if (!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.lowercase().equals("cap type", true)) {
                binding.itemValue.text = product?.productspec?.capscaptype?.toString()
                if (!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.lowercase().equals("end type", true)) {
                binding.itemValue.text = product?.productspec?.capsendtype?.toString()
                if (!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
        }

            if (productGroupType.equals("Hub Cover Locks", true)){
                if (itemname.lowercase().equals("material",true)){
                binding.itemValue.text = product?.productspec?.hubmaterial?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.lowercase().equals("lock thread length",true)){
                binding.itemValue.text = product?.productspec?.hubcoverlockthreadlength?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.lowercase().equals("lock thread pitch",true)){
                binding.itemValue.text = product?.productspec?.hubcoverlockthreadpitch?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.lowercase().equals("inside diameter",true)){
                binding.itemValue.text = product?.productspec?.hubringinsidediameter?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.lowercase().equals("outside diameter",true)){
                binding.itemValue.text = product?.productspec?.hubringoutsidediameter?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.lowercase().equals("inside diameter (from vendor)",true)){
                binding.itemValue.text = product?.productspec?.hubringveninsidediameter?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.lowercase().equals("outside diameter (from vendor)",true)){
                binding.itemValue.text = product?.productspec?.hubringvenoutsidediameter?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            }

            if (productGroupType.equals("Install Kits", true)) {
                if (itemname.lowercase().equals("type", true)) {
                    binding.itemValue.text = product?.productspec?.installkitstype?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("color", true)) {
                    binding.itemValue.text = product?.productspec?.installkitscolor?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("finish", true)) {
                    binding.itemValue.text = product?.productspec?.installkitsfinish?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("overall length", true)) {
                    binding.itemValue.text =
                        product?.productspec?.installkitsoveralllength?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("pitch", true)) {
                    binding.itemValue.text = product?.productspec?.installkitspitch?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("key - part number", true)) {
                    binding.itemValue.text = product?.productspec?.installkitskeypartnum?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("key - quantity", true)) {
                    binding.itemValue.text =
                        product?.productspec?.installkitskeyquantity?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("lock - part number", true)) {
                    binding.itemValue.text =
                        product?.productspec?.installkitslockpartnum?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("lock - quantity", true)) {
                    binding.itemValue.text =
                        product?.productspec?.installkitslockquantity?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("lug - part number", true)) {
                    binding.itemValue.text = product?.productspec?.installkitslugpartnum?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("lug - quantity", true)) {
                    binding.itemValue.text =
                        product?.productspec?.installkitslugquantity?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("socket - part number", true)) {
                    binding.itemValue.text =
                        product?.productspec?.installkitssocketpartnum?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("socket - quantity", true)) {
                    binding.itemValue.text =
                        product?.productspec?.installkitssocketquantity?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("thread length", true)) {
                    binding.itemValue.text =
                        product?.productspec?.installkitsthreadlength?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("thread pitch", true)) {
                    binding.itemValue.text =
                        product?.productspec?.installkitsthreadpitch?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Value Stem Temp - Part Number", true)) {
                    binding.itemValue.text =
                        product?.productspec?.installkitsvalvestempartnum?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Value Stem Temp - Quantity", true)) {
                    binding.itemValue.text =
                        product?.productspec?.installkitsvalvestemquantity?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Washer - Part Number", true)) {
                    binding.itemValue.text =
                        product?.productspec?.installkitswasherpartnum?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Washer - Quantity", true)) {
                    binding.itemValue.text =
                        product?.productspec?.installkitswasherquantity?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
            }

            if (productGroupType.equals("Lug Bolts", true)) {

                if (itemname.lowercase().equals("Finish", true)) {
                    binding.itemValue.text = product?.productspec?.lugboltsfinish?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Overall Length", true)) {
                    binding.itemValue.text = product?.productspec?.lugboltsfinish?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Outside Diameter", true)) {
                    binding.itemValue.text =
                        product?.productspec?.lugboltsoveralldiameter?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Drive Gender", true)) {
                    binding.itemValue.text = product?.productspec?.lugboltsdrivegender?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Drive Size", true)) {
                    binding.itemValue.text = product?.productspec?.lugboltsdrivesize?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Drive Type", true)) {
                    binding.itemValue.text = product?.productspec?.lugboltsdrivetype?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Seat Angle", true)) {
                    binding.itemValue.text = product?.productspec?.lugboltsseatangle?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Seat Type", true)) {
                    binding.itemValue.text = product?.productspec?.lugboltsseattype?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Threaded Length", true)) {
                    binding.itemValue.text =
                        product?.productspec?.lugboltsthreadedlength?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }

                if (itemname.lowercase().equals("Thread Pitch", true)) {
                    binding.itemValue.text = product?.productspec?.lugboltsthreadpitch?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
            }

            if (productGroupType.equals("Lug Nuts", true)) {

                if (itemname.lowercase().equals("Lug Nut Type", true)) {
                    binding.itemValue.text =
                        product?.productspec?.wheelaccessorylugnuttype?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Finish", true)) {
                    binding.itemValue.text = product?.productspec?.lugnutsfinish?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Outside Diameter", true)) {
                    binding.itemValue.text = product?.productspec?.lugnutsouterdiameter?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Overall Length", true)) {
                    binding.itemValue.text = product?.productspec?.lugnutsoveralllength?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Ball Diameter", true)) {
                    binding.itemValue.text = product?.productspec?.lugnutsballdiameter?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Drive Type", true)) {
                    binding.itemValue.text = product?.productspec?.lugnutsdrivetype?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Drive Size", true)) {
                    binding.itemValue.text = product?.productspec?.lugnutsdrivesize?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Duplex", true)) {
                    binding.itemValue.text = product?.productspec?.lugnutsduplexflag?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Pitch Direction", true)) {
                    binding.itemValue.text = product?.productspec?.lugnutspitchdirection?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Seat Angle", true)) {
                    binding.itemValue.text = product?.productspec?.lugnutsseatangle?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Seat Type", true)) {
                    binding.itemValue.text = product?.productspec?.lugnutsseattype?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Send Type", true)) {
                    binding.itemValue.text = product?.productspec?.lugnutsendtype?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Shank Diameter", true)) {
                    binding.itemValue.text = product?.productspec?.lugnutsshankdiameter?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Shank Length", true)) {
                    binding.itemValue.text = product?.productspec?.lugnutsshanklength?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Splines", true)) {
                    binding.itemValue.text = product?.productspec?.lugnutssplines?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Thread Pitch", true)) {
                    binding.itemValue.text = product?.productspec?.lugnutsthreadpitch?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
            }

            if (productGroupType.equals("Wheel Accessories", true)) {

                if (itemname.lowercase().equals("Color", true)) {
                    binding.itemValue.text = product?.productspec?.wheelaccessorycolor?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Male End", true)) {
                    binding.itemValue.text =
                        product?.productspec?.wheelaccesstoolsmaleend?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Female End", true)) {
                    binding.itemValue.text =
                        product?.productspec?.wheelaccesstoolsfemaleend?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Type", true)) {
                    binding.itemValue.text = product?.productspec?.wheelaccesstoolstype?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Total Height", true)) {
                    binding.itemValue.text =
                        product?.productspec?.wheelaccesstoolstotalheight?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Outside Diameter", true)) {
                    binding.itemValue.text =
                        product?.productspec?.wheelaccesstoolsoutsidediameter?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Stepped Inside", true)) {
                    binding.itemValue.text =
                        product?.productspec?.wheelaccesstoolssteppedinside?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Stepped Outside", true)) {
                    binding.itemValue.text =
                        product?.productspec?.wheelaccesstoolssteppedoutside?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
            }

            if (productGroupType.equals("Wheel Studs", true)) {

                if (itemname.lowercase().equals("Type", true)) {
                    binding.itemValue.text = product?.productspec?.wheelstudtype?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Overall Length", true)) {
                    binding.itemValue.text =
                        product?.productspec?.wheelstudoveralllength?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Hub Tread Length", true)) {
                    binding.itemValue.text =
                        product?.productspec?.wheelstudhubthreadpitch?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.lowercase().equals("Wheel Thread Pitch", true)) {
                    binding.itemValue.text =
                        product?.productspec?.wheelstudwheelthreadpitch?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.equals("Side Thread Length", true)) {
                    binding.itemValue.text =
                        product?.productspec?.wheelstudsidethreadlength?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
            }
            if (productGroupType.equals("Wheel Valve Stem", true)) {

                if (itemname.equals("Valve Type", true)) {
                    binding.itemValue.text =
                        product?.productspec?.wheelvalvestemsvalvetype?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.equals("Mount Type", true)) {
                    binding.itemValue.text =
                        product?.productspec?.wheelvalvestemsmounttype?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.equals("Mount Location", true)) {
                    binding.itemValue.text =
                        product?.productspec?.wheelvalvestemsmountlocation?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.equals("Hole Diameter", true)) {
                    binding.itemValue.text =
                        product?.productspec?.wheelvalvestemsholediameter?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.equals("Stem Angle", true)) {
                    binding.itemValue.text =
                        product?.productspec?.wheelvalvestemsstemangle?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.equals("Effective Length", true)) {
                    binding.itemValue.text =
                        product?.productspec?.wheelvalvestemseffectivelength?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.equals("High Pressure", true)) {
                    binding.itemValue.text =
                        product?.productspec?.wheelvalvestemshighpressure?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.equals("Material", true)) {
                    binding.itemValue.text =
                        product?.productspec?.wheelvalvestemsmaterial?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
            }

            if (productGroupType.equals("TPMS", true)) {

                if (itemname.equals("Type", true)) {
                    binding.itemValue.text = product?.productspec?.tpmstype?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.equals("Lug Bore", true)) {
                    binding.itemValue.text = product?.productspec?.tpmslugbore?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.equals("Color", true)) {
                    binding.itemValue.text = product?.productspec?.tpmscolor?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.equals("Kit Color", true)) {
                    binding.itemValue.text = product?.productspec?.tpmskitcolor?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.equals("Units of Measure", true)) {
                    binding.itemValue.text = product?.productspec?.tpmssellinguom?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.equals("Universal Sensor", true)) {
                    binding.itemValue.text = product?.productspec?.tpmsuniversalsensor?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.equals("OE Supplier", true)) {
                    binding.itemValue.text = product?.productspec?.tpmsoesupplier?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.equals("Vehicle Origin", true)) {
                    binding.itemValue.text = product?.productspec?.tpmsvehicleorigin?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.equals("Material", true)) {
                    binding.itemValue.text = product?.productspec?.tpmsmaterial?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
            }

            if (productGroupType.equals("Wheel Weights", true)) {

                if (itemname.equals("Type", true)) {
                    binding.itemValue.text = product?.productspec?.wheelweightstype?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.equals("Color", true)) {
                    binding.itemValue.text = product?.productspec?.wheelweightscolor?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
                if (itemname.equals("Material", true)) {
                    binding.itemValue.text = product?.productspec?.wheelweightsmaterial?.toString()
                    if (!binding.itemValue.text.toString()
                            .equals("")
                    ) tvProductInformation.visible()
                }
            }
            if (productGroupType.equals("Tubes & Flaps", true)) {

                if (itemname.equals("Diameter",true)){
                binding.itemValue.text = product?.productspec?.tubesdiameter?.toString()+","+ product?.productspec?.tubesdiameter2?.toString()+","+product?.productspec?.tubesdiameter3?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.equals("Valve",true)){
                binding.itemValue.text = product?.productspec?.tubesvalve?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            }

            if (productGroupType.equals("Tire Repair", true)) {

                if (itemname.equals("Tire Type",true)){
                binding.itemValue.text = product?.productspec?.tirerepairtiretype?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.equals("Diameter",true)){
                binding.itemValue.text = product?.productspec?.tirerepairdiameter?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.equals("Rim Size",true)){
                binding.itemValue.text = product?.productspec?.tirerepairrimsize?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.equals("Color",true)){
                binding.itemValue.text = product?.productspec?.tirerepaircolor?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.equals("Ply",true)){
                binding.itemValue.text = product?.productspec?.tirerepairply?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.equals("Range",true)){
                binding.itemValue.text = product?.productspec?.tirerepairrange?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.equals("Maximum RPM",true)){
                binding.itemValue.text = product?.productspec?.tirerepairmaxrpm?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.equals("Shape",true)){
                binding.itemValue.text = product?.productspec?.tirerepairshape?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.equals("Bias/Radial",true)){
                binding.itemValue.text = product?.productspec?.tirerepairbiasradialflag?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.equals("Bias Tire?",true)){
                binding.itemValue.text = product?.productspec?.tirerepairbiastireflag?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.equals("Radial Tire?",true)){
                binding.itemValue.text = product?.productspec?.tirerepairradialtireflag?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.equals("Arbor Hole",true)){
                binding.itemValue.text = product?.productspec?.tirerepairarborhole?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.equals("Blade Length",true)){
                binding.itemValue.text = product?.productspec?.tirerepairbladelength?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.equals("Shaft Size",true)){
                binding.itemValue.text = product?.productspec?.tirerepairshaftsize?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }

            }

            if (productGroupType.equals("Tools", true)) {

                if (itemname.equals("Grit",true)){
                binding.itemValue.text = product?.productspec?.tirerepairssggrit?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.equals("Thread Size",true)){
                binding.itemValue.text = product?.productspec?.tirerepairthreadsize?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.equals("Unit of Measurement",true)){
                binding.itemValue.text = product?.productspec?.tirerepairsellinguom?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.equals("Shelf Life",true)){
                binding.itemValue.text = product?.productspec?.tirerepairshelflife?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.equals("Length",true)){
                binding.itemValue.text = product?.productspec?.toolslength?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.equals("Output Size",true)){
                binding.itemValue.text = product?.productspec?.toolsoutputsize?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.equals("Drive Size",true)){
                binding.itemValue.text = product?.productspec?.toolsdrivesize?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.equals("Air Consumption",true)){
                binding.itemValue.text = product?.productspec?.toolsairconsumption?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.equals("Air Requirements",true)){
                binding.itemValue.text = product?.productspec?.toolsairrequirements?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.equals("Maximum Torque",true)){
                binding.itemValue.text = product?.productspec?.toolsmaxtorq?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.equals("Minimum Hose Size",true)){
                binding.itemValue.text = product?.productspec?.toolsminhosesize?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.equals("Sea Metric",true)){
                binding.itemValue.text = product?.productspec?.toolsseametric?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            if (itemname.equals("Model Number",true)){
                binding.itemValue.text = product?.productspec?.toolsmodelnum?.toString()
                if(!binding.itemValue.text.toString().equals("")) tvProductInformation.visible()
            }
            }


            //Precision treaddepth


            if (binding.itemValue.text.toString().equals("0") || binding.itemValue.text.toString().equals("") ){
                binding.itemValue.gone()
                binding.item.gone()
                binding.divider.gone()
            }else{
                binding.itemValue.visible()
                binding.item.visible()
                binding.divider.visible()
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {

        val binding = FragmentProductAttributesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return listOfData.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {


        holder.bind(listOfData.get(position),product,productGroupType)
    }

}
