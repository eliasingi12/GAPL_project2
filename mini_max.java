package GAPL_project2;

import java.util.List;

import org.ggp.base.util.statemachine.MachineState;
import org.ggp.base.util.statemachine.Move;
import org.ggp.base.util.statemachine.Role;
import org.ggp.base.util.statemachine.StateMachine;
import org.ggp.base.util.statemachine.exceptions.MoveDefinitionException;
import org.ggp.base.util.statemachine.exceptions.TransitionDefinitionException;

import javafx.util.Pair;


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

	/*** Fyrirlestur psudo code
	 * @throws MoveDefinitionException
	 * @throws TransitionDefinitionException ***/

	public static Pair<Integer, Move> MaxValue(MachineState state, Role role, StateMachine s) throws MoveDefinitionException, TransitionDefinitionException
	{
		System.out.println("Entering MaxValue...\n");
		int bestValue = Integer.MIN_VALUE;
		if(s.isTerminal(state))
		{
			System.out.println("Entering MaxValue terminal state");
			return new Pair<>(bestValue, null); // evaluation function TODO
		}

		Move returnMove = null;
		for(Move move : s.getLegalMoves(state, role))
		{
			System.out.println("Entering MaxValue for-loop...\n");
			int childValue = MinValue(s.getNextState(state, s.getLegalMoves(state, role)), role, s, move);
			bestValue = Math.max(childValue, bestValue);
			returnMove = move;
		}

		System.out.println("Returning in MaxValue \n");
		return new Pair<>(bestValue, returnMove);
	}

	public static int MinValue(MachineState state, Role role, StateMachine s, Move move) throws MoveDefinitionException, TransitionDefinitionException
	{
		System.out.println("Entering MinValue...\n");
		int bestValue = Integer.MAX_VALUE;
		if(s.isTerminal(state))
		{
			System.out.println("Entering MinValue terminal state");
			return bestValue; // evaluation function TODO
		}

		for(List<Move> jm : s.getLegalJointMoves(state, role, move))
		{
			System.out.println("Entering MaxValue for-loop...\n");
			Pair<Integer, Move> PairValue = MaxValue(s.getNextState(state, jm), role, s);
			bestValue = Math.min((int) PairValue.getKey(), bestValue);
		}

		System.out.println("Returning in MinValue \n");
		return bestValue;
	}
}
