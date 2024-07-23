package com.example.pratica_compose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import com.example.pratica_compose.ui.theme.PraticacomposeTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PraticacomposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { ComposeCardArtigo()}
            }
        }
    }
}

@Composable
fun ComposeCardArtigo() {
    CardArtigo(
        titulo = stringResource(R.string.compose_titulo),
        descricaoBreve = stringResource(R.string.compose_descricaoBreve),
        descricaoLonga = stringResource(R.string.compose_descricaoLonga),
        imagem = painterResource(R.drawable.bg_compose_background)
    )
}

@Composable
private fun CardArtigo(titulo: String, descricaoBreve: String, descricaoLonga: String, imagem: Painter, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Image(painter = imagem, contentDescription = null)
        Text(
            text= titulo,
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp
        )
        Text(
            text = descricaoBreve,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = descricaoLonga,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CardArtigoPreview() {
    CardArtigo(
        titulo = stringResource(R.string.compose_titulo),
        descricaoBreve = stringResource(R.string.compose_descricaoBreve),
        descricaoLonga = stringResource(R.string.compose_descricaoLonga),
        imagem = painterResource(R.drawable.bg_compose_background)
    )
}

@Composable
private fun TaskCompleta() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        val imagem = painterResource(R.drawable.ic_task_completed)
        Image(painter = imagem, contentDescription = null)
        Text(
            text = stringResource(R.string.TodasTarefasCompletadas),
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.bomTrabalho),
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TaskCompletaPreview() {
    TaskCompleta()
}

@Composable
fun ComposeQuadrantApp() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                titulo = stringResource(R.string.primeiroTitulo),
                descricao = stringResource(R.string.primeiraDescricao),
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                titulo = stringResource(R.string.segundoTitulo),
                descricao = stringResource(R.string.segundaDescricao),
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                titulo = stringResource(R.string.terceiroTitulo),
                descricao = stringResource(R.string.terceiraDescricao),
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                titulo = stringResource(R.string.quartoTitulo),
                descricao = stringResource(R.string.quartaDescricao),
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun ComposableInfoCard(
    titulo: String,
    descricao: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier
        .fillMaxSize()
        .background(backgroundColor)
        .padding(16.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = titulo,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = descricao,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantAppPreview() {
        ComposeQuadrantApp()
}