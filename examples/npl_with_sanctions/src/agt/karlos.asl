+!setup_npl : focusing(ArtSai,inst_test_art,_,_,inst_test,_) 
    <- makeArtifact(nb1,"sai.bridges.jacamo.NormativeBoardSai",[],AId);
       focus(AId);
       debug(inspector_gui(on));
       load("src/org/demo.npl");       
       makeArtifact(ps1,"police.Sanctioner",[],SArt);
       listen(AId)[artifact_id(SArt)]; // ps1 get normative events (including sanctions) from nb1       
       .

-!setup_npl
   <- .wait(500);
      !setup_npl.

//connect norms to institution
+!setup_sai: focusing(ArtSai,inst_test_art,_,_,inst_test,_) 
             & focusing(NplArt,nb1,_,_,_,_) 
             &  focusing(EnactArt,enact_art,_,_,_,_) //enact artifact
             &  focusing(EnactListenerArt,enact_listener,_,_,_,_) //enact artifact
<- getSaiEngine(SE)[artifact_id(ArtSai)];
   setInstitution(SE)[artifact_id(NplArt)];
   getEnactListener(EnactListener)[artifact_id(EnactListenerArt)];
   addInstitutionalFactSource(SaiEngine)[artifact_id(EnactArt)];     
   addEnactListener(EnactListener)[artifact_id(EnactArt)];      
   getNormativeListener(EnactNormativeListener)[artifact_id(EnactArt)];
   addNormativeListener(EnactNormativeListener)[artifact_id(NplArt)];
  .

-!setup_sai
   <- .wait(500);
      !setup_sai.


//start the clock artifact
+!manage_clock <-  
    setFrequency(1);     
    start; //start the clock
.      


+oblUnfulfilled(O) <- .print("Unfulfilled ",O).

+sanction(NormId,Event,Ag,Sanction) <- .print("Sanction ",Sanction," for ",Ag," created from norm ", NormId, " that is ",Event).


{ include("$jacamo/templates/common-cartago.asl") }
{ include("$jacamo/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moise/asl/org-obedient.asl") }
