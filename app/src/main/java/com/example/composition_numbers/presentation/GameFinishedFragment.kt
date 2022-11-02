package com.example.composition_numbers.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentManager
import com.example.composition_numbers.R
import com.example.composition_numbers.databinding.FragmentChooseLevelBinding
import com.example.composition_numbers.databinding.FragmentGameFinishedBinding
import com.example.composition_numbers.domain.entity.GameResult
import com.example.composition_numbers.domain.entity.Level

class GameFinishedFragment : Fragment() {

    private lateinit var gameResult: GameResult

    private var _binding: FragmentGameFinishedBinding? = null
    private val binding: FragmentGameFinishedBinding
        get() = _binding ?: throw RuntimeException("FragmentChooseLevelBinding == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentGameFinishedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews()
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    retryGame()
                }
            })
        binding.buttonRetry.setOnClickListener {
            retryGame()
        }

    }

    private fun bindViews(){
        binding.emojiResult.setImageResource(getSmileId())

        binding.tvRequiredAnswers.text = String.format(getString(R.string.required_score),
        gameResult.gameSettings.minCountOfRightCount)

        binding.tvScoreAnswers.text = String.format(getString(R.string.score_answers),
        gameResult.countOfRightAnswers)

        binding.tvScorePercentage.text = String.format(getString(R.string.score_percentage),
        gameResult.gameSettings.minPercentOfRightAnswer)

        binding.tvRequiredPercentage.text = String.format(getString(R.string.required_percentage),
        getPrecentOfRightAnswers())
    }

    private fun getPrecentOfRightAnswers() = with(gameResult){
        if (countOfQuestion == 0) {
             0
        }
         ((countOfRightAnswers / countOfQuestion.toDouble()) * 100).toInt()
    }

    private fun getSmileId():Int{
        return if (gameResult.winner){
            R.drawable.ic_smile
        }else{
            R.drawable.ic_bad
        }
    }

    private fun retryGame() {
        requireActivity().supportFragmentManager.popBackStack(
            GameFragment.NAME,
            FragmentManager.POP_BACK_STACK_INCLUSIVE
        )
    }


    private fun parseArgs() {
        requireArguments().getParcelable<GameResult>(KEY_GAME_RESULT)?.let {
            gameResult = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private const val KEY_GAME_RESULT = "Game result"

        fun newInstance(gameResult: GameResult): GameFinishedFragment {
            return GameFinishedFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_GAME_RESULT, gameResult)
                }
            }
        }
    }

}