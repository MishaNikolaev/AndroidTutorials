package com.example.patterns_clean_architecture.patterns


//Queen at C3 is represented as "qc3"
//Pawn at A8 is represented as "pa8"
//King at E2 is represented as "ke2"
//Bishop at H4 is represented as "bh4"
//Knight at F3 is represented as "nf3"
//Rook at A1 is represented as "ra1"

interface ChessPiece {
    val file: Char
    val rank: Char
}

class Pawn(override val file: Char, override val rank: Char) : ChessPiece
class Queen(override val file: Char, override val rank: Char) : ChessPiece
class King(override val file: Char, override val rank: Char) : ChessPiece
class Bishop(override val file: Char, override val rank: Char) : ChessPiece
class Knight(override val file: Char, override val rank: Char) : ChessPiece
class Rook(override val file: Char, override val rank: Char) : ChessPiece

fun main() {
    val notations = listOf(
        "pa8",
        "qc3",
        "ra1",
        "bh4",
        "ke2",
        "nf3",
        "pd2",
        "pe4",
        "pd7",
        "pe5",
        "nf6",
        "pe6",
        "nf7",
        "pe7",
        "nf8",
        "pe8",
        "ng8",
        "pf2",
        "pg2",
        "ph2",
        "pb1",
        "pg1",
        "ph1",
        "rb8",
        "bb7",
        "bc8",
        "bd7",
        "be8",
        "bf7",
        "bg8",
        "bh7",
        "rc1",
        "nb1",
        "nc3",
        "nd2",
        "ne1",
        "nf2",
        "ng1",
        "nh2",
        "rd8",
        "ke8",
        "kf8",
        "kg8",
        "kh8",
        "ki8",
        "kf7",
        "kg7",
        "kh7",
        "ki7",
        "kf6",
        "kg6",
        "kh6",
        "ki6",
        "kf5",
        "kg5",
        "kh5",
        "ki5",
        "kf4",
        "kg4",
        "kh4",
        "ki4",
        "kf3",
        "kg3",
        "kh3",
        "ki3",
        "kf2",
        "kg2",
        "kh2",
        "ki2",
        "kf1",
        "kg1",
        "kh1",
        "ki1"
    )
    val pieces = mutableListOf<ChessPiece>()

    for(notation in notations) {
        val piece = create(notation)
        pieces.add(piece)
    }

    printGame(pieces)
}

private fun printGame(pieces: List<ChessPiece>) {
    pieces.forEach { piece ->
        println("${piece.javaClass.simpleName} at ${piece.file}${piece.rank}")
    }
}

fun create(notation: String) : ChessPiece {
    val (type, file, rank) = notation.toCharArray()
    return when (type) {
        'p' -> Pawn(file, rank)
        'q' -> Queen(file, rank)
        'k' -> King(file, rank)
        'b' -> Bishop(file, rank)
        'n' -> Knight(file, rank)
        'r' -> Rook(file, rank)
        else -> throw IllegalArgumentException("Unknown $type")
    }
}
