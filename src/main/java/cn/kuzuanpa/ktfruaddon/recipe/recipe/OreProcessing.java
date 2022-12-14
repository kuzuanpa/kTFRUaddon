package cn.kuzuanpa.ktfruaddon.recipe.recipe;

import cpw.mods.fml.common.FMLLog;
import gregapi.data.FL;
import gregapi.data.MT;
import gregapi.data.OP;
import gregapi.data.RM;
import gregapi.oredict.OreDictMaterial;
import gregapi.recipes.Recipe;
import gregapi.util.OM;
import gregapi.util.ST;
import org.apache.logging.log4j.Level;

import java.util.List;

import static cn.kuzuanpa.ktfruaddon.recipe.recipeManager.HeatMixer;
import static gregapi.data.CS.*;

public class OreProcessing {
    public OreProcessing() {
  //Cr processing
       // final Recipe.RecipeMap recipeMap;
        RM.Bath.addRecipeX(T,0, 512 , ST.array(OM.dust(OreDictMaterial.get(9113), U*2), OM.dust(OreDictMaterial.get(30014), U*9)), FL.array(MT.H2SO4.liquid(6000,T)), FL.array(FL.Water.make(4000)), OM.dust(OreDictMaterial.get(30012), U*6), OM.dust(OreDictMaterial.get(30013), U*3));
        RM.Mixer.addRecipeX(T,64,82,ST.array(ZL_IS),FL.array(MT.NH3.gas(2000,T),MT.H2SO4.liquid(U , T)), FL.array(ZL_FS),OM.dust(OreDictMaterial.get(30014),U*9));
        HeatMixer.addRecipeX(T,256,160,ST.array(OM.dust(OreDictMaterial.get(30011))),FL.array(MT.O.gas(U *4,T )),FL.array(FL.Nitrogen.make(250)),OM.dust(MT.CrO2, U * 2));
       // recipeMap = Recipe.RecipeMap.RECIPE_MAPS.get("gt.recipe.electrolyzer");
       // recipeMap.mRecipeList.removeAll(recipeMap.getNEIRecipes(OP.dust.mat(MT.Cr,U)));
       // FMLLog.log(Level.FATAL," "+ recipeMap.mRecipeList + recipeMap.getNEIRecipes(OP.dust.mat(MT.Cr,U)));

        //Al processing
        //Step1:Bauxide process
        HeatMixer.addRecipeX(T,120,80,ST.array(OM.dust(MT.CaCO3,U),OM.dust(MT.Na2CO3,U *2), OM.dust(OreDictMaterial.get(9105),U)),ZL_FS,FL.CarbonDioxide.make(3000),OM.dust(OreDictMaterial.get(30020),U*2));
        RM.Bath.addRecipeX(T, 0, 80, ST.array(OM.dust(OreDictMaterial.get(9105),U)),FL.array(MT.H2SO4.liquid(U *4 ,T)),FL.array(FL.make("acidpickledbauxide",2000)),OM.dust(MT.SiO2,U));
        RM.Bath.addRecipeX(T, 0, 180, ST.array(OM.dust(OreDictMaterial.get(9105),U),OM.dust(MT.NaOH,U*2)),FL.array(MT.H2O.liquid(1000 ,T)),FL.array(FL.make("sodiumaluminate",2000)),OM.dust(MT.SiO2,U4),OM.crushedCentrifugedTiny(OreDictMaterial.get(9120),1));
        //Step2
        RM.Bath.addRecipeX(T, 0, 180, ST.array(OM.dust(OreDictMaterial.get(30020),U*2),OM.dust(MT.NaOH,U*2)),FL.array(MT.H2O.liquid(1000 ,T)),FL.array(FL.make("sodiumaluminate",2000)),OM.dust(MT.SiO2,U4),OM.dust(OreDictMaterial.get(30022),U));
        HeatMixer.addRecipeX(T,120,60,ST.array(OM.dust(MT.NaOH,U * 4)),FL.array(FL.make("acidpickledbauxide",2000)),FL.array(FL.make("mixtureoffe2o3na2so4",1000),FL.make("sodiumaluminate",2000)),ZL_IS);
        RM.Mixer.addRecipeX(T,0, 800,ST.array(ZL_IS),FL.array(FL.make("sodiumaluminate",1000),FL.Soda.make(1000)),FL.array(FL.make("asodiumcarbonate",2000)),OM.dust(MT.AlO3H3,U*4));
        //Step3: Centrifuge for mixtures
        RM.Centrifuge.addRecipeX(T, 64, 40,ST.array(OM.dust(OreDictMaterial.get(30022),U)),FL.array(ZL_FS),FL.array(ZL_FS),OM.dust(MT.Fe2O3,U),OM.crushedCentrifugedTiny(MT.TiO2,1),OM.dust(MT.SiO2,U4));
        RM.Centrifuge.addRecipeX(T, 32, 20, ST.array(ZL_IS),FL.array(FL.make("mixtureoffe2o3na2so4",1000)),FL.array(ZL_FS),OM.dust(MT.Na2SO4,4*U),OM.dust(MT.Fe2O3,U));
      //Use K for sone recipe
        //Step1
        RM.Bath.addRecipeX(T, 0, 180, ST.array(OM.dust(OreDictMaterial.get(9105),U),OM.dust(MT.KOH,U*2)),FL.array(MT.H2O.liquid(1000 ,T)),FL.array(FL.make("potassiumaluminate",2000)),OM.dust(MT.SiO2,U4),OM.crushedCentrifugedTiny(OreDictMaterial.get(9120),1));
        //Step2
        HeatMixer.addRecipeX(T,120,60,ST.array(OM.dust(MT.KOH,U * 4)),FL.array(FL.make("acidpickledbauxide",2000)),FL.array(FL.make("mixtureoffe2o3k2so4",1000),FL.make("potassiumaluminate",2000)),ZL_IS);
        RM.Mixer.addRecipeX(T,0, 800,ST.array(ZL_IS),FL.array(FL.make("potassiumaluminate",1000),FL.Soda.make(1000)),FL.array(FL.make("asodiumcarbonate",2000)),OM.dust(MT.AlO3H3,U*4));
        //Step3
        RM.Centrifuge.addRecipeX(T, 32, 20, ST.array(ZL_IS),FL.array(FL.make("mixtureoffe2o3k2so4",1000)),FL.array(ZL_FS),OM.dust(MT.K2SO4,4*U),OM.dust(MT.Fe2O3,U));
      //transformation between solution and dusts
        //NaAlO2
        RM.Drying.addRecipeX(T,32,40, ST.array(ZL_IS),FL.array(FL.make("sodiumaluminate",1000)),FL.array(FL.DistW.make(750)),OM.dust(MT.NaAlO2,U));
        RM.Mixer.addRecipeX(T,16,10, ST.array(OM.dust(MT.NaAlO2,U)),FL.array(MT.H2O.liquid(U , T)),FL.array(FL.make("sodiumaluminate",1000)),ZL_IS);
        RM.Bath.addRecipeX(T,0,20, ST.array(OM.dust(MT.NaAlO2,U)),FL.array(MT.H2O.liquid(U , T)),FL.array(FL.make("sodiumaluminate",1000)),ZL_IS);
        //KAlO2
        RM.Drying.addRecipeX(T,32,40, ST.array(ZL_IS),FL.array(FL.make("potassiumaluminate",1000)),FL.array(FL.DistW.make(750)),OM.dust(MT.KAlO2,U));
        RM.Mixer.addRecipeX(T,16,10, ST.array(OM.dust(MT.KAlO2,U)),FL.array(MT.H2O.liquid(U , T)),FL.array(FL.make("potassiumaluminate",1000)),ZL_IS);
        RM.Bath.addRecipeX(T,0,20, ST.array(OM.dust(MT.KAlO2,U)),FL.array(MT.H2O.liquid(U , T)),FL.array(FL.make("potassiumaluminate",1000)),ZL_IS);
        //K2CO3
        RM.Drying.addRecipeX(T,32,40, ST.array(ZL_IS),FL.array(FL.make("potassiumcarbonate",1000)),FL.array(FL.DistW.make(750)),OM.dust(MT.K2CO3,U));
        RM.Bath.addRecipeX(T,0,20, ST.array(OM.dust(MT.K2CO3,U)),FL.array(MT.H2O.liquid(U , T)),FL.array(FL.make("potassiumcarbonate",1000)),ZL_IS);
        //NaCO3
        RM.Drying.addRecipeX(T,32,40, ST.array(ZL_IS),FL.array(FL.make("asodiumcarbonate",1000)),FL.array(FL.DistW.make(750)),OM.dust(MT.Na2CO3,U));
        RM.Bath.addRecipeX(T,0,20, ST.array(OM.dust(MT.Na2CO3,U)),FL.array(MT.H2O.liquid(U , T)),FL.array(FL.make("asodiumcarbonate",1000)),ZL_IS);
      //W Process
        RM.Autoclave.addRecipe2(T, 0, 400,new long[] {10000} ,OP.dust.mat(MT.OREMATS.Wolframite,1),OP.dust.mat(MT.NaOH,4),FL.Steam.make(20000),FL.make("sodiumheterotungstate",2000),OM.dust(MT.MgCO3, U));
        RM.Autoclave.addRecipe2(T, 0, 400,new long[]{10000},OP.dust.mat(MT.OREMATS.Huebnerite,1),OP.dust.mat(MT.NaOH,4),FL.Steam.make(20000),FL.make("sodiumheterotungstate",2000),OM.dust(MT.MnO2, U));
        RM.Autoclave.addRecipe2(T, 0, 400,new long[] {10000} ,OP.dust.mat(MT.OREMATS.Scheelite,1),OP.dust.mat(MT.Na2CO3,2),FL.Steam.make(20000),FL.make("sodiumheterotungstate",2000),OM.dust(MT.CaCO3, U));
        RM.Autoclave.addRecipe2(T, 0, 400,new long[]{10000},OP.dust.mat(MT.OREMATS.Tungstate,1),OP.dust.mat(MT.Na2CO3,2),FL.Steam.make(20000),FL.make("sodiumheterotungstate",2000),OM.dust(OreDictMaterial.get(30030), U));
        RM.Mixer.addRecipeX(T,64, 100, ST.array(ZL_IS),FL.array(FL.make("sodiumheterotungstate",4000),FL.make("hydrochloricacid",4000)),FL.array(FL.make("saltwater",8000)),OM.dust(MT.H2WO4,3*U));
        RM.Mixer.addRecipeX(T,64, 100, ST.array(ZL_IS),FL.array(FL.make("sodiumheterotungstate",4000),FL.make("ammonia",4000)),FL.array(FL.make("ammoniumtungstate",2000)),OM.dust(MT.NaOH,4*U));
        RM.Drying.addRecipeX(T,32,40, ST.array(ZL_IS),FL.array(FL.make("sodiumheterotungstate",1000)),FL.array(FL.DistW.make(700)),OM.dust(MT.WO3,U));
      //Ti Process
        RM.Bath.addRecipeX(T,0,120,ST.array(OM.dust(MT.OREMATS.Ilmenite,2*U)),FL.array(MT.H2SO4.liquid(7*U,T)),FL.array(FL.make("martianvitriol",6000)),OM.dust(OreDictMaterial.get(30040),4*U));
        RM.Drying.addRecipeX(T,32,40, ST.array(OM.dust(OreDictMaterial.get(30040),2*U)),FL.array(ZL_FS),FL.array(FL.DistW.make(200)),OM.dust(MT.TiO2,U));
        HeatMixer.addRecipeX(T,158,60,ST.array(ZL_IS),FL.array(MT.TiCl4.liquid(5*U,T),MT.Ar.gas(1,T),MT.Mg.liquid(U*2,T)),FL.array(MT.Ti.liquid(6*U4,T)),OM.dust(MT.MgCl2,6*U));


    }
}
