// Agent Giacomo, who wants to build a house

{ include("$jacamoJar/templates/common-cartago.asl") }
//{ include("$jacamoJar/templates/common-moise.asl") }
{ include("common.asl") }
{ include("org_code.asl") }

/* Initial beliefs and rules */

// counts the number of tasks based on the observable properties of the auction artifacts
number_of_tasks(NS) :- .findall( S, task(S), L) & .length(L,NS).


/* Initial goals */

!have_a_house.


/* Plans */

+!setup_enact: focusing(InstArt,bh_art,_,_,_,_)  //constitutive artifact
               &  focusing(EnactArt,enact_art,_,_,_,_) //enact artifact
               &  focusing(EnactListenerArt,enact_listener,_,_,_,_) //enact artifact
    <- //lookupArtifact(/main/bh/bh_art,InstArt);     //TENTAR COM O NOME DO WORKSPACE
       !in_ora4mas;
       lookupArtifact("bhsch", SchArt);
       focus(SchArt);
       getSaiEngine(SaiEngine)[artifact_id(InstArt)];
       getEnactListener(EnactListener)[artifact_id(EnactListenerArt)];
       addInstitutionalFactSource(SaiEngine)[artifact_id(EnactArt)];     
       addEnactListener(EnactListener)[artifact_id(EnactArt)];      
       getNormativeListener(EnactNormativeListener)[artifact_id(EnactArt)];
       addNormativeListener(EnactNormativeListener)[artifact_id(SchArt)];
       .

-!setup_enact
   <- .wait(500);
      !setup_enact.

+!have_a_house
   <- !contract; // hire the companies that will build the house
      !execute.  // (simulates) the execution of the construction

-!have_a_house[error(E),error_msg(Msg),code(Cmd),code_src(Src),code_line(Line)]
   <- .print("Failed to build a house due to: ",Msg," (",E,"). Command: ",Cmd, " on ",Src,":", Line).


/* Plans for Contracting */

+!contract
   <- setFrequency(1)[artifact_id(Clock)];
      start[artifact_id(Clock)]; //while the clock is counting the bidders can bid
      ?nticks(Starting_Auction_Time);
      +starting_auction_time(Starting_Auction_Time);
      !wait_for_bids.



+!wait_for_bids:nticks(X)&(X>=8000) // use an internal deadline of 5 seconds to close the auctions
   <- stop[artifact_id(Clock)];
      !show_winners.


+!wait_for_bids
   <- ?nticks(X);
      ?starting_auction_time(Starting_Auction_Time);
      println("Waiting the bids ", 8000-X," seconds...");
      .wait(500);
      !wait_for_bids;
      .

+!show_winners
   <- for ( currentWinner(Ag)[artifact_id(ArtId)] ) {
         ?currentBid(Price)[artifact_id(ArtId)]; // check the current bid
         ?task(Task)[artifact_id(ArtId)];          // and the task it is for
         println("Winner of task ", Task," is ", Ag, " for ", Price)
      }.


/* Plans for managing the execution of the house construction */

+!execute
   <- println;
      println("*** Execution Phase ***");
      println;

      // create the GUI artifact
      joinWorkspace("/main",_);
      createWorkspace("wsp_house");
      joinWorkspace("/main/wsp_house",WspHouse);

      makeArtifact("housegui", "simulator.House")[wid(WspHouse)];
      lookupArtifact("housegui", HouseArt);
      focus(HouseArt);


      joinWorkspace("/main/bh",_);
      lookupArtifact("bh_art", InstArt);
      focus(InstArt);
      getRuleEngine(RE)[artifact_id(InstArt)];

      joinWorkspace("/main/wsp_house",WspHouse2);
      setWSPRuleEngine(RE)[artifact_id(WspHouse2)]; //links the woskspace "wsp_house" to SAI. Thus, the SAI engine is fed with the environmental facts from that workspace

      !setup_enact;
      !in_ora4mas;
      !contract_winners("hsh_group").


+!contract_winners(GroupName)
    : number_of_tasks(NS) &
      .findall( ArtId, currentWinner(A)[artifact_id(ArtId)] & A \== "no_winner", L) &
      .length(L, NS)
   <- for ( currentWinner(Ag)[artifact_id(ArtId)] ) {
            ?task(Task)[artifact_id(ArtId)];
            println("Contracting ",Ag," for ", Task);
            .send(Ag, achieve, contract(Task,GroupName)) // sends the message to the agent notifying it about the result
      }.

+!contract_winners(_)
   <- println("** I didn't find enough builders!");
      .fail.


+!house_built.