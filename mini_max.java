package GAPL_project2;

public class mini_max {

	/******* Project description *******/
	/* Implement Minimax search and play the best move found.
	 * You should use iterative deepening, otherwise dealing with the time constraints becomes hard.
	 * The Gamer class you created has a method getCurrentState() to get the current state of the game
	 * and getStateMachine() to get a state machine representing the game.
	 * This state machine can be used to get legal moves, compute successor states, ...,
	 * that you will need to implement the search.*/

	/****** Alpha-Beta Psudo code ****** //

	// max_value(state of the world we are in, best alternative for max on this particular path through the tree (from the root node to "state"), best alternative for min)
	max_value(state, alpha, beta)
	{
		if(terminal(state))
			return U(s);

		init_value = -inf;

		for(c in next_states(state)) // successor states
		{
			// min_value(current state, current value of alpha, current value of beta)
			child_value = min_value(c, alpha, beta);
			if(child_value > init_value)
				init_value = new_value;
			if(child_value >= beta)
				return init_value;
			if(child_value > alpha)
				alpha = child_value;
		}
		return child_value;
	}

	// min_value(state of the world we are in, best alternative for max on this particular path through the tree (from the root node to "state"), best alternative for min)
	min_value(state, alpha, beta)
	{
		if(terminal(state))
			return U(s);

		init_value = +inf;

		for(c in next_states(state)) // successor states
		{
			// max_value(current state, current value of alpha, current value of beta)
			child_value = max_value(c, alpha, beta);
			if(child_value < init_value)
				init_value = child_value;
			if(child_value <= alpha)
				return init_value;
			if(child_value < beta)
				beta = child_value;
		}
		return init_value;
	}
	*/

	/*** Fyrirlestur psudo code ***/
	/*
	Value Minimax(state s, . . . .)
	{
		terminal(s) eitthvað.. // base case calla á utility function sem skilar einhverju gildi fyrir max-playerinn
		bestValue = -inf;
		foreach(action in legalMoves(getRole(), s))
		{
			v = MinValue(s, getRole(), a);
			bestValue = max(v, bestValue);
		}
		return bestValue; // þarf líka að “returna” eða halda utanum hvaða move var valið…
	}

	Value MinValue(state, role, action/move)
	{
		bestValue = +inf;
		foreach(f in “stjatemachine” getJointMoves(state, role, action))
		{
			v = Minimax(nextState(state, jm)) // jm returns a list of legal joint moves for all players
		}
	}
	*/

}
