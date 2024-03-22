package com.dipen.funfact.ui

import androidx.lifecycle.ViewModel

class FactViewModel : ViewModel() {

    fun generateRandomFacts(selectedAnimal : String) : String{
        return if(selectedAnimal == "DOG") getDogFacts().random() else getCatFacts().random()
    }

    private fun getDogFacts() = listOf(
        "Dogs have a sense of time and can predict future events, such as regular walk times.",
        "A dog’s sense of smell is 10,000 to 100,000 times more acute than humans.",
        "The Basenji dog is known as the “barkless dog” due to its unusual yodel-like sound.",
        "The world’s oldest known breed is the Saluki, originally bred in Egypt around 329 B.C.",
        "Dogs have three eyelids, including one to keep their eyes moist and protected.",
        "A Greyhound is the fastest dog breed and can run up to 45 miles per hour.",
        "The Newfoundland breed has webbed feet and is an excellent swimmer.",
        "Dogs can understand up to 250 words and gestures.",
        "The average dog can run about 19 miles per hour at full speed.",
        "The Border Collie is considered the smartest dog breed.",
        "Dogs curl up in a ball when sleeping to protect their organs—a holdover from their days in the wild.",
        "The Norwegian Lundehund is the only dog with six toes on each foot.",
        "Dogs’ nose prints are as unique as human fingerprints and can be used to identify them.",
        "The world’s first dog lived 31,700 years ago.",
        "The Dalmatian’s spots only appear as they age.",
        "A dog’s sense of hearing is more than ten times more acute than a human’s.",
        "The Chihuahua is the smallest dog breed.",
        "The St. Bernard is the heaviest dog breed.",
        "Dogs can be trained to detect diseases in humans, such as cancer and diabetes.",
        "The oldest dog on record was an Australian Cattle Dog named Bluey, who lived to be 29 years and 5 months."
    )


    private fun getCatFacts() = listOf(
        "Cats have five toes on their front paws but only four toes on their back paws.",
        "A group of cats is called a clowder.",
        "Cats can rotate their ears 180 degrees.",
        "The world's oldest cat lived to be 38 years old.",
        "Cats can make over 100 vocal sounds, while dogs only make about 10.",
        "A cat's nose is as unique as a human's fingerprint.",
        "Cats sleep for 70% of their lives.",
        "The largest breed of domestic cat is the Maine Coon.",
        "Cats have a third eyelid called a haw, which helps protect their eyes.",
        "The first cat in space was a French cat named Félicette in 1963.",
        "Cats have a specialized collarbone that allows them to always land on their feet.",
        "A cat’s whiskers are roughly as wide as its body, helping it to gauge space and distance.",
        "Ancient Egyptians worshipped cats and even mummified them for their journey to the afterlife.",
        "Cats can’t taste sweetness due to a genetic mutation.",
        "The record for the longest cat ever is 48.5 inches.",
        "Cats can jump up to six times their body length in a single leap.",
        "The first cat show was held in London in 1871.",
        "A cat's purr may be a form of self-healing, as it can be a sign of nervousness as well as contentment.",
        "The world’s richest cat had a fortune of $13 million left to it by its owner.",
        "Cats have been domesticated for about 4,000 years, though they’ve likely been around humans much longer."
    )
}